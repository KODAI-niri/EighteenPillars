package example;

import java.awt.Graphics2D;

/**
 * V : ビュー。表示回りを専門に行うクラス。
 */
public class View extends Object
{
	/**
	 * 情報を司るModelのインスタンスを束縛するフィールド
	 */
	protected Model aModel;

	/**
	 * 制御を司るControllerのインスタンスを束縛するフィールド
	 */
	protected Controller aController;

	/**
	 * 地面のインスタンスを束縛するフィールド
	 */
	private Ground ground;

	/**
	 * Ground上の軌跡を描画して記憶している画像のグラフィクスコンテキストを束縛するフィールド
	 */
	private Graphics2D pen;

	/**
	 * インスタンスを生成して応答するコンストラクタ。
	 * 指定されたモデルの依存物となり、
	 * コントローラを作成し、そのコントローラにモデルとビューを設定する。
	 * @param aModel このビューのモデル(観測するもの)
	 */
	public View(Model aModel) 
	{
		super();
		this.aModel = aModel;
		this.aModel.addDependent(this);
		this.aController = new Controller();
		this.aController.setModel(aModel);
		this.aController.setView(this);
		this.ground = new Ground(this.aController);
		this.setPen();
		return;
	}

	/**
	 * インスタンスを生成して応答するコンストラクタ。
	 * 指定されたモデルの依存物となり、
	 * 指定されたコントローラにモデルとビューを設定する。
	 * @param aModel このビューのモデル
	 * @param aController このビューのコントローラ
	 */
	public View(Model aModel, Controller aController) 
	{
		super();
		this.aModel = aModel;
		this.aModel.addDependent(this);
		this.aController = aController;
		this.aController.setModel(aModel);
		this.aController.setView(this);
		this.ground = new Ground(this.aController);
		this.setPen();
		return;
	}

	/**
	 * 自身が束縛しているグラウンドを応答するメソッド
	 * @return グラウンド
	 */
	public Ground getGround()
	{
		return this.ground;
	}

	/**
	 * グラウンドに自信へと渡されたキーコードを設定する。
	 */
	public void setKeyCodeToGround(Integer keyCode)
	{
		this.ground.setKeyCode(keyCode);
		return;
	}

	/**
	 * 自身が持つフィールドにGroundのグラフィクスコンテキストを設定する。
	 */
	public void setPen()
	{
		this.pen = this.ground.getPen();
		return;
	}

	/**
	 * ウィンドウを綺麗にする。(つまり今まで描いたものを無に帰す)
	 */
	public void showClearRect()
	{
		this.ground.setJudge(false);
		this.aModel.changed();
	}

	/**
	 * 柱をグラウンド上に描き、それを表示するメソッド。
	 */
	public void showPillar()
	{
		this.ground.setJudge(true);
		this.aModel.changed();
		return;
	}
	
	/**
	 * 自身を文字列にして応答する。
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
}
