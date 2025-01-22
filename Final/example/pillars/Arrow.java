package example.pillars;

import condition.Condition;
import condition.ValueHolder;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 柱のうち、矢印に関するデータを保持し、それを描くクラスである。
 */
public class Arrow extends Object
{
    /**
     * 矢印のうち、線分の始点のx座標を束縛するフィールド。
     */
    private Integer x1;

    /**
     * 矢印のうち、線分の終点のx座標を束縛するフィールド。
     */
    private Integer x2;

    /**
     * 三角形の全てのx座標を束縛するフィールド
     */
    private int[] polygonX;

    /**
     * 教科・教員名に関するクラスのインスタンスを束縛するフィールド
     */
    private Subject aSubject;

    /**
     * 矢印のコンストラクタ。
     * @param x1 線分の始点のx座標
     * @param x2 線分の終点のx座標
     * @param polygonX 三角形の全てのx座標
     * @param aSubject 教科・教員名に関するクラスのインスタンス
     */
    public Arrow(Integer x1, Integer x2,
                int[] polygonX, Subject aSubject)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.polygonX = polygonX;
        this.aSubject = aSubject;
        return;
    }

    /**
     * 柱のうち、矢印を描くメソッド。
     * @param aGraphics グラフィクスコンテキスト
     * @param numberOfArrowAndSubject 矢印あるいは教科・教員数
     */
    public void drawArrow(Graphics aGraphics, Integer numberOfArrowAndSubject)
    {
        aGraphics.setColor(new Color(0, 0, 0));
        ValueHolder<Integer> indexHolder = new ValueHolder<Integer>(0);
        new Condition(() -> indexHolder.get() < numberOfArrowAndSubject).whileTrue(() ->
        {
            Integer y = this.aSubject.getY(indexHolder.get()) + (this.aSubject.getHeight() / 2);
            aGraphics.drawLine(this.x1, y, this.x2, y);
            Integer y1 = this.aSubject.getY(indexHolder.get());
            Integer y2 = y1 + this.aSubject.getHeight();
            int[] polygonY = new int[]{y1, y2, y};
            aGraphics.fillPolygon(this.polygonX, polygonY, 3);
            indexHolder.set(indexHolder.get() + 1);
        });
        return;
    }

    /**
     * 自身を文字列にして応答する。
     * @return 自身の文字列
     */
    public String toString()
    {
        Class<?> aClass = this.getClass();
        StringBuffer aBuffer = new StringBuffer();

        aBuffer.append(aClass.getName());
        aBuffer.append("[x1=");
        aBuffer.append(this.x1);
        aBuffer.append(",x2=");
        aBuffer.append(this.x2);
        aBuffer.append(",polygonX=");

        ValueHolder<Boolean> aBooleanHolder = new ValueHolder<Boolean>(true);
        ValueHolder<Integer> indexHolder = new ValueHolder<Integer>(0);
        new Condition(() -> indexHolder.get() < this.polygonX.length).whileTrue(() ->
        {
            new Condition(() -> aBooleanHolder.get()).ifThenElse(
            () -> aBooleanHolder.set(false),
            () -> aBuffer.append(","));
            aBuffer.append(String.valueOf(this.polygonX[indexHolder.get()]));
            indexHolder.set(indexHolder.get() + 1);
        });
        aBuffer.append("]");

        return aBuffer.toString();
    }
}
