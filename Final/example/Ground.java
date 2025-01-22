package example;

import condition.Condition;
import condition.ValueHolder;

import example.pillars.cc.*; // 全てを用いるので、ワイルドカードでインポート

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * 柱を描くウィンドウ(地面)の表示の専任クラスである
 */
@SuppressWarnings("serial")
public class Ground extends JPanel 
{
    /**
     * 地面の幅を記憶するフィールド(クラス定数)である。
     */
	public static final Integer WIDTH = 900;

    /**
     * 地面の高さを記憶するフィールド（クラス定数）である。
     */
	public static final Integer HEIGHT = 800;

    /**
     * 制御を司るコントローラのインスタンスを束縛するフィールド。
     */
    protected Controller aController;

    /**
     * 地面のシングルトン(唯一のインスタンス)を束縛するフィールド(クラス定数)である
     */
	private static Ground singleton;

    /**
     * ウィンドウ上に図形を描くかどうかを決めるもの。
     */
    private boolean aJudge; 

    /**
     * キーコードを束縛するフィールド
     */
    private Integer keyCode;

    /**
     * 柱が描かれた軌跡を描画して記憶している画像を束縛するフィールドである。
     */
	private BufferedImage picture;

    /**
     * 上記のpicture画像のグラフィクスコンテキストを束縛するフィールドである。
     */
	private Graphics2D pen;

    /**
     * キーコードに応じて、描画する柱を変更するマップを束縛するフィールド。
     */
    private Map<Integer, Consumer<Graphics>> actionMap = new HashMap<Integer, Consumer<Graphics>>();

    /**
     * 地面のコンストラクタである。
     * 但し、柱を描くウィンドウは単一であるのが好ましいので、
     * View以外からはアクセスしないようにすること。
     */
    public Ground(Controller aController) 
    {
        this.picture = new BufferedImage(Ground.WIDTH, Ground.HEIGHT, BufferedImage.TYPE_INT_RGB);
        this.clear();
        this.setController(aController);
        Ground.singleton = this;

        this.initActionMap();
        
        JFrame aFrame = new JFrame("18本の柱");
        JMenuBar aMenuBar = this.menuBar();
        aFrame.setJMenuBar(aMenuBar);
        aFrame.addKeyListener(this.aController);
		aFrame.getContentPane().add(this);

		// ウィンドウのタイトルバーとメニューバーの高さを算出して、ウィンドウの大きさを決める。
		aFrame.addNotify(); // コンポーネントのサイズを決めるように促す。
		aFrame.pack(); // それらのサイズによりフレーム内の配置を決めるように促す。
		Integer topOffset = aFrame.getInsets().top + aMenuBar.getHeight();
		aFrame.setSize(Ground.WIDTH, Ground.HEIGHT + topOffset);

		// ウィンドウの各種設定を行って、ウィンドウを開く。
		aFrame.setResizable(false);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setLocation(100, 0);
		aFrame.setVisible(true);
		aFrame.setAlwaysOnTop(true);

        return;
	}

    /**
     * 地面をクリアにする。
     */
	public void clear() 
    {
        Color aColor = new Color(234, 234, 234);
        this.clear(aColor);

        return;
	}

    /**
     * 色を指定して地面をクリアにする。
     * @param aColor 色のインスタンス(地面の色)
     */
	public void clear(Color aColor) 
    {
        this.pen().setColor(aColor);
        this.pen().fillRect(0, 0, Ground.WIDTH, Ground.HEIGHT);

        this.display();

        return;
	}

    /**
     * 地面を描画する。
     */
	public void display() 
    {
        this.repaint(0, 0, this.getWidth(), this.getHeight());

        return;
	}

    /**
     * 自身が束縛しているグラフィクスコンテキストを応答する。
     * @return グラフィクスコンテキスト
     */
    public Graphics2D getPen()
    {
        return this.pen;
    }

    /**
     * メニューバーを作成して応答する。
     * @return メニューバーのインスタンス
     */
	public JMenuBar menuBar() 
    {
        JMenuBar aMenuBar = new JMenuBar();

        JMenu aMenu = null;
        ActionListener aListener = null;

        aMenu = new JMenu("ファイル");
        aListener = new ActionListener() 
        {
            public void actionPerformed(ActionEvent anEvent)
            {
                try
                {
                    String aCommand = anEvent.getActionCommand();
                    ValueHolder<String> eventValueHolder = new ValueHolder<String>(aCommand);
                    new Condition(() -> eventValueHolder.get().equals("終了")).ifTrue(() ->
                    {
                        System.exit(0);
                    });
                }
                catch (ConcurrentModificationException anException) { ; }
                return;
            }
            
        };
        aMenu.add("終了").addActionListener(aListener);
        aMenuBar.add(aMenu);
		return aMenuBar;
	}

    /**
     * 自身が持つアクションマップ(actionMap: キーコードに応じて描画する柱を変更するマップ)を
     * 初期化する
     */
    private void initActionMap()
    {
        this.actionMap.put(KeyEvent.VK_A, g -> new AL().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_B, g -> new AR().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_C, g -> new CN().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_D, g -> new DS().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_E, g -> new GV().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_F, g -> new HCI().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_G, g -> new IAS().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_H, g -> new IM().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_I, g -> new IS().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_J, g -> new NC().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_K, g -> new OS().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_L, g -> new PBD().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_M, g -> new PD().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_N, g -> new PL().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_O, g -> new SDF().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_P, g -> new SE().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_Q, g -> new SF().drawPillar(g));
        this.actionMap.put(KeyEvent.VK_R, g -> new SP().drawPillar(g));
    }

    /**
     * 地面を描画する。
     * @param aGraphics グラフィクスコンテキスト
     */
    protected void paintComponent(Graphics aGraphics) 
    {
        try
		{
			super.paintComponent(aGraphics);

            ValueHolder<Boolean> judgeHolder = new ValueHolder<Boolean>(this.aJudge);
            new Condition(() -> judgeHolder.get()).ifTrue(() ->
            {
                ValueHolder<Integer> keyCodeHolder = new ValueHolder<Integer>(this.keyCode);
                new Condition(() -> this.actionMap.containsKey(keyCodeHolder.get())).ifTrue(() ->
                {
                    this.actionMap.get(keyCodeHolder.get()).accept(aGraphics);
                });
            });
            new Condition(() -> !judgeHolder.get()).ifTrue(() ->
            {
                aGraphics.setColor(new Color(234, 234, 234));
                aGraphics.drawRect(0, 0, Ground.WIDTH, Ground.HEIGHT);
            });
		}
		catch (ConcurrentModificationException anException) { ; }

        return;
	}

    /**
     * 地面を画板に見立てた時のグラフィクスコンテキストを応答する。
     * @return グラフィクスコンテキスト
     */
	protected Graphics2D pen() 
    {
		if (this.pen == null)
        {
            this.pen = this.picture.createGraphics();
        }

        return this.pen;
	}

    /**
     * 制御を司るコントローラのインスタンスをフィールドに設定する。
     * @param aController 制御を司るコントローラのインスタンス
     */
    public void setController(Controller aController)
    {
        this.aController = aController;
        return;
    }

    /**
     * 図形をウィンドウ上に描くかどうかのジャッジを設定する。
     * @param aBoolean true or false
     */
    public void setJudge(boolean aBoolean)
    {
        this.aJudge = aBoolean;
        return;
    }

    /**
     * 自身のフィールドにキーコードを設定する
     */
    public void setKeyCode(Integer keyCode)
    {
        this.keyCode = keyCode;
        return;
    }

    /**
     * 指定された時間(ミリ秒)だけスリープする
     * @param milliseconds ミリ秒
     */
    public static void sleep(Integer milliseconds)
    {
        try
		{
			Thread.sleep((long)milliseconds);
		}
		catch (InterruptedException anException)
		{
			anException.printStackTrace();
		}

		return;
    }

    /**
     * 自信を文字列にして応答する。
     * @return 自身の文字列
     */
    public String toString()
    {
        StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();

		aBuffer.append(aClass.getName());
		aBuffer.append("pen=");
		aBuffer.append(this.pen);
		aBuffer.append("]");

		return aBuffer.toString();
    }

    /**
	 * ビューの全領域を再描画する。
	 */
	public void update()
	{
		this.repaint(0, 0, this.getWidth(), this.getHeight());
		return;
	}
}
