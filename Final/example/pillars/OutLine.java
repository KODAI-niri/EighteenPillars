package example.pillars;

import condition.Condition;
import condition.ValueHolder;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 柱における、円柱と教科・教師名を描く四角形の輪郭を描くクラスである。
 */
public class OutLine extends Object
{
    /**
     * 教科、教員名に関するクラスのインスタンスを束縛するフィールド
     */
    private Subject aSubject;

    /**
     * 円柱に関するクラスのインスタンスを束縛するフィールド
     */
    private Cylinder aCylinder;

    /**
     * 輪郭のコンストラクタ。
     * @param aSubject 教科、教員名に関するクラスのインスタンス
     */
    public OutLine(Subject aSubject, Cylinder aCylinder)
    {
        this.aSubject = aSubject;
        this.aCylinder = aCylinder;
        return;
    }

    /**
     * 円柱と四角形の輪郭を描く。
     * @param aGraphics グラフィクスコンテキスト
     * @param numberOfArrowAndSubject 矢印あるいは教科・教員数
     */
    public void drawOutLine(Graphics aGraphics, Integer numberOfArrowAndSubject)
    {
        this.drawOutLineOfCylinder(aGraphics);
        this.drawOutLineOfSubject(aGraphics, numberOfArrowAndSubject);
        return;
    }
    
    /**
     * 円柱の輪郭を描くメソッド。
     * @param aGraphics グラフィクスコンテキスト
     */
    public void drawOutLineOfCylinder(Graphics aGraphics)
    {
        aGraphics.setColor(new Color(0, 0, 0));
        aGraphics.drawLine(this.aCylinder.getX(), this.aCylinder.getY(), 
                        this.aCylinder.getX(), this.aCylinder.getY() + this.aCylinder.getHeight());
        aGraphics.drawLine(this.aCylinder.getX() + this.aCylinder.getWidth(), this.aCylinder.getY(), 
                        this.aCylinder.getX() + this.aCylinder.getWidth(), this.aCylinder.getY() + this.aCylinder.getHeight());
        aGraphics.drawOval(this.aCylinder.getX(), this.aCylinder.getY() - this.aCylinder.getSubstractionY(0), this.aCylinder.getWidth(), this.aCylinder.getHeight() - this.aCylinder.getSubstractionHeight(0));
        aGraphics.drawArc(this.aCylinder.getX(), this.aCylinder.getY() - this.aCylinder.getSubstractionY(1), this.aCylinder.getWidth(), this.aCylinder.getHeight() - this.aCylinder.getSubstractionHeight(1),
                            180, 180);
        return;
    }

    /**
     * 教科・教員名の土台となる四角形の輪郭を描くメソッド。
     * @param aGraphics グラフィクスコンテキスト
     * @param numberOfArrowAndSubject 矢印あるいは教科・教員数
     */
    public void drawOutLineOfSubject(Graphics aGraphics, Integer numberOfArrowAndSubject)
    {
        ValueHolder<Integer> indexHolder = new ValueHolder<Integer>(0);
        new Condition(() -> indexHolder.get() < numberOfArrowAndSubject).whileTrue(() ->
        {
            aGraphics.drawRect(this.aSubject.getX(), this.aSubject.getY(indexHolder.get()),
                            this.aSubject.getWidth(indexHolder.get()), this.aSubject.getHeight());
            indexHolder.set(indexHolder.get() + 1);
        });
        return;
    }
}
