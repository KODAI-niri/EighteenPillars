package example;

/**
 * MVC(モデル・ビュー・コントローラ)モデルを用いて、
 * 18の柱をウィンドウ上に描きだすという例題プログラムである。
 */
public class Example extends Object 
{
	/**
	 * 例題のメイン(main)プログラム。
	 * @param arguments 引数の文字列型配列
	 */

	public static void main(String[] arguments) 
	{
		Model aModel = new Model();

		View aView = new View(aModel);
		return;
	}

}
