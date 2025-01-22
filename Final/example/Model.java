package example;

/**
 * M : モデル。データの管理を専門に行うクラス。
 */
public class Model extends Object 
{
	/**
	 * このクラスの観察者(Observer)であるViewのインスタンスを束縛するフィールド
	 */
	protected View aDependent;

	/**
	 * インスタンスを生成して初期化して応答するコンストラクタ。
	 */
	public Model() 
	{
		super();
		this.initialize();
		return;
	}

	/**
	 * 指定されたビューを依存物に設定する。
	 * @param aView このモデルの依存物となるビュー
	 */
	public void addDependent(View aView) 
	{
		this.aDependent = aView;
		return;
	}

	/**
	 * モデルの内部状態が変化していたので、
	 * 自分の依存物へupdateのメッセージを送信(broadcast: 放送)する。
	 */
	public void changed() 
	{
		this.aDependent.getGround().update();
	}

	/**
	 * 自身のフィールド、つまり依存物を初期化する
	 */
	public void initialize() 
	{
		this.aDependent = null;
	}

	/**
	 * 自身を文字列にして応答する
	 * @return 自身の文字列
	 */
	public String toString() 
	{
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());

		return aBuffer.toString();
	}

}
