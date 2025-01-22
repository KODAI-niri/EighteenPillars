package example.pillars;

import java.awt.Font;
import java.awt.Graphics;

import java.util.List;

public class Pillar extends Object
{
    /**
     * 円柱に関するクラスのインスタンスを束縛するフィールド
     */
    private Cylinder aCylinder;

    /**
     * 矢印に関するクラスのインスタンスを束縛するフィールド
     */
    private Arrow anArrow;

    /**
     * 教科・教員名に関するクラスのインスタンスを束縛するフィールド
     */
    private Subject aSubject;

    /**
     * 輪郭に関するクラスのインスタンスを束縛するフィールド
     */
    private OutLine anOutLine;

    /**
     * Subjectあるいは矢印の個数を記憶するフィールドである。
     */
    private Integer numberOfArrowAndSubject;

    /**
     * 円柱のコンストラクタである。
     * @param numberOfArrowAndSubject 矢印あるいは教科・教員数
     */
    public Pillar(Integer numberOfArrowAndSubject)
    {
        this.numberOfArrowAndSubject = numberOfArrowAndSubject;
        return;
    }

    /**
     * グラフィクスコンテキストを用いて、柱を描くメソッド。
     * @param aGraphics グラフィクスコンテキスト
     */
    public void drawPillar(Graphics aGraphics)
    {
        this.aCylinder.drawCylinder(aGraphics);
        this.aSubject.drawSubject(aGraphics, this.numberOfArrowAndSubject);
        this.anArrow.drawArrow(aGraphics, this.numberOfArrowAndSubject);
        this.anOutLine.drawOutLine(aGraphics, this.numberOfArrowAndSubject);
        return;
    }

    /**
     * 与えられたパラメタを、自身のArrowフィールドにセットする。
     * @param x1 線分の始点のx座標
     * @param x2 線分の終点のx座標
     * @param polygonX 三角形の全ての頂点のx座標
     */
    public void setArrow(Integer x1, Integer x2, int[] polygonX)
    {
        this.anArrow = new Arrow(x1, x2, polygonX, this.aSubject);
    }

    /**
     * 与えられたパラメタを、自身のCylinderフィールドにセットする
     * @param x 円柱を描くのに必要な(一番左上の)x座標
     * @param y　円柱を描くのに必要な(一番左上の)y座標
     * @param width 円柱の幅
     * @param height 円柱の高さ
     * @param font フォントのインスタンス
     * @param ySubstractionList y座標の差分をまとめたリスト
     * @param heightSubstractionList 高さの差分をまとめたリスト
     */
    public void setCylinder(Integer x, Integer y, Integer width,
                            Integer height, Font font, String computingCorricula,
                            List<Integer> ySubstractionList, List<Integer> heightSubstractionList)
    {
        this.aCylinder = new Cylinder(x, y, width, height, font, computingCorricula, ySubstractionList, heightSubstractionList);
        return;
    }

    /**
     * 自身のOutLineフィールドにインスタンスを束縛させる。
     */
    public void setOutLine()
    {
        this.anOutLine = new OutLine(this.aSubject, this.aCylinder);
    }

    /**
     * 与えられたパラメタを、自身のSubjectフィールドにセットする。
     * @param x 四角形の一番左上のx座標
     * @param height 四角形の高さ
     * @param font フォントのインスタンス
     * @param subjects 全ての教科・教員名を束縛している群れオブジェクト
     */
    public void setSubject(Integer x, Integer height, Font font, Integer space, List<String> subjects)
    {
        this.aSubject = new Subject(x, height, font, this.aCylinder, space, subjects);
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
        aBuffer.append("[Cylinder=");
        aBuffer.append(this.aCylinder);
        aBuffer.append(",Arrow=");
        aBuffer.append(this.anArrow);
        aBuffer.append(",Subject=");
        aBuffer.append(this.aSubject);
        aBuffer.append("]");

        return aBuffer.toString();
    }
}
