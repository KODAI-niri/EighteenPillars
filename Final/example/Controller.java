package example;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import condition.Condition;
import condition.ValueHolder;

/**
 * C : コントローラ。制御回りを専門に行うクラスである。
 */
public class Controller implements KeyListener 
{
	/**
	 * 情報を司るModelのインスタンスを束縛するフィールド
	 */
	protected Model aModel;

	/**
	 * 表示を司るViewのインスタンスを束縛するフィールド
	 */
	protected View aView;

	/**
	 * インスタンスを生成して応答するコンストラクタ。
	 */
	public Controller() 
	{
		this.aModel = null;
		this.aView = null;
		return;
	}

	/**
	 * 押下されたキー情報を獲得し、
	 * 対応する柱をウィンドウ上に描き出す。
	 * @param aKeyEvent キーイベント
	 */
	public void keyPressed(KeyEvent aKeyEvent) 
	{
		int keyCode = aKeyEvent.getKeyCode();
		ValueHolder<Integer> keyCodeHolder = new ValueHolder<Integer>(keyCode);
		ValueHolder<Integer> zKeyHolder = new ValueHolder<Integer>(KeyEvent.VK_Z);
		ValueHolder<Integer> sKeyHolder = new ValueHolder<Integer>(KeyEvent.VK_S);
		ValueHolder<Integer> yKeyHolder = new ValueHolder<Integer>(KeyEvent.VK_Y);
		ValueHolder<Integer> aKeyHolder = new ValueHolder<Integer>(KeyEvent.VK_A);
		ValueHolder<Integer> rKeyHolder = new ValueHolder<Integer>(KeyEvent.VK_R);
		new Condition(() -> keyCodeHolder.get().equals(zKeyHolder.get())).ifTrue(() ->
		{
			this.aView.showClearRect();
		});
		new Condition(() -> sKeyHolder.get() <= keyCodeHolder.get()).ifTrue(() ->
		{
			new Condition(() -> keyCodeHolder.get() <= yKeyHolder.get()).ifTrue(() ->
			{
				// 何もしない
			});
		});
		new Condition(() -> aKeyHolder.get() <= keyCodeHolder.get()).ifTrue(() ->
		{
			new Condition(() -> keyCodeHolder.get() <= rKeyHolder.get()).ifTrue(() ->
			{
				this.aView.setKeyCodeToGround(keyCodeHolder.get());
				this.aView.showPillar();
			});
		});
		return;
	}

	/**
	 * 何もしない。
	 * @param aKeyEvent キーイベント
	 */
	public void keyReleased(KeyEvent aKeyEvent) 
	{
		return;
	}

	/**
	 * 何もしない。
	 * @param aKeyEvent キーイベント
	 */
	public void keyTyped(KeyEvent aKeyEvent) 
	{
		return;
	}

	/**
	 * 指定されたモデルをインスタンス変数aModelに設定する。
	 * @param aModel コントローラが観察するModel
	 */
	public void setModel(Model aModel) 
	{
		this.aModel = aModel;
		return;
	}

	/**
	 * 指定されたビューをインスタンス変数aViewに設定し、
	 * ビューのキーリスナーを自身にする。
	 * @param aView このコントローラーが参照するビュー
	 */
	public void setView(View aView) 
	{
		this.aView = aView;
		return;
	}

	/**
	 * 自身を文字列にして応答する。
	 * @return 自分自身を表す文字列
	 */
	public String toString() 
	{
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[model=");
		aBuffer.append(this.aModel);
		aBuffer.append(",view=");
		aBuffer.append(this.aView);
		aBuffer.append("]");
		return aBuffer.toString();
	}

}
