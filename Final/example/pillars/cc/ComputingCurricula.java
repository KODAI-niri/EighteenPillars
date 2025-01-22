package example.pillars.cc;

import java.awt.Graphics;

/**
 * 柱たちが兼ね備えなければならないメソッドのスタブを定義するインタフェース
 */
public interface ComputingCurricula 
{
    /**
     * 柱を描く抽象的なメソッドである。
     * @param aGraphics グラフィクスコンテキスト
     */
    public void drawPillar(Graphics aGraphics);

    /**
     * Arrowクラスに必要な情報を渡して、そのコンストラクタを生成する
     */
    public void setArrow();

    /**
     * Cylinderクラスに必要な情報を渡して、そのコンストラクタを生成する
     */
    public void setCylinder();

    /**
     * OutLineクラスに必要な情報を渡して、そのコンストラクタを生成する
     */
    public void setOutLine();

    /**
     * Subjectクラスに必要な情報を渡して、そのコンストラクタを生成する
     */
    public void setSubject();
}
