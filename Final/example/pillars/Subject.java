package example.pillars;

import condition.Condition;
import condition.ValueHolder;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import example.Ground;

/**
 * 教科・教員名に関するデータを束縛し、それを描くクラスである。
 */
public class Subject extends Object
{
    /**
     * 四角形の一番左上のx座標を束縛するフィールド
     */
    private Integer x;

    /**
     * 四角形の一番左上のy座標を複数束縛する群れオブジェクト
     */
    private List<Integer> yList;

    /**
     * 四角形の水平方向の幅を複数束縛する群れオブジェクト
     */
    private List<Integer> widthList;

    /**
     * 四角形の高さを束縛するフィールド
     */
    private Integer height;

    /**
     * 四角形同士の一番左上のy座標の間隔を記憶するクラス定数である。
     */
    private Integer space;

    /**
     * このPCの水平方向のDPIを記憶するクラス定数である。
     */
    public static final Integer DPI = 140;

    /**
     * 複数の色の情報を、整数による単写で束縛しているマップ(辞書)である。
     */
    private Map<Integer, Color> colorDictionary;

    /**
     * フォントのインスタンスを束縛するフィールド
     */
    private Font font;

    /**
     * 教科・教員名を複数縛る群れオブジェクトである。
     */
    private List<String> subjects;

    /**
     * 円柱に関する情報を縛り、その円柱を描くクラスのインスタンスを束縛するフィールド
     */
    private Cylinder aCylinder;

    /**
     * 教科・教員名のコンストラクタ。
     * @param x 四角形の一番左上のx座標
     * @param height 四角形の高さ
     * @param font フォントのインスタンス
     * @param space 四角形同士の間隔
     */
    public Subject(Integer x,Integer height, 
                    Font font, Cylinder aCylinder, Integer space, List<String> subjects)
    {
        this.x = x;
        this.yList = new ArrayList<Integer>();
        this.widthList = new ArrayList<Integer>();
        this.height = height;
        this.colorDictionary = new HashMap<Integer, Color>();
        this.initColorDictionary();
        this.font = font;
        this.subjects = subjects;
        this.aCylinder = aCylinder;
        this.space = space;
        return;
    }

    /**
     * 教科・教員名を描くメソッド
     * @param aGraphics グラフィクスコンテキスト
     * @param numberOfArrowAndSubject 矢印あるいは教科・教員数
     */
    public void drawSubject(Graphics aGraphics, Integer numberOfArrowAndSubject)
    {
        aGraphics.setFont(this.font);
        ValueHolder<Integer> indexHolder = new ValueHolder<Integer>(0);
        ValueHolder<Integer> numberOfArrowAndSubjectHolder = new ValueHolder<Integer>(numberOfArrowAndSubject);
        new Condition(() -> indexHolder.get() < numberOfArrowAndSubject).whileTrue(() ->
        {
            aGraphics.setColor(this.colorDictionary.get(2));
            Integer y = this.aCylinder.getY() + (indexHolder.get() * this.space) - 20;
            ValueHolder<Integer> yHolder = new ValueHolder<Integer>(y);
            new Condition(() -> numberOfArrowAndSubjectHolder.get().equals(1)).ifTrue(() ->
            {
                Integer temporaryValue = this.aCylinder.getY() + (this.aCylinder.getHeight() / 2) - 20;
                yHolder.set(temporaryValue);
            });
            Integer width = (this.font.getSize() * Subject.DPI * this.subjects.get(indexHolder.get()).length()) / 72;
            ValueHolder<Integer> widthHolder = new ValueHolder<Integer>(width);
            new Condition(() -> this.x + widthHolder.get() > Ground.WIDTH).ifTrue(() ->
            {
                Integer temporaryValue = Ground.WIDTH - this.x;
                widthHolder.set(temporaryValue);
            });
            FontMetrics aFontMetrics = aGraphics.getFontMetrics();
            int textWidth = aFontMetrics.stringWidth(this.subjects.get(indexHolder.get()));
            new Condition(() -> widthHolder.get() > textWidth).ifTrue(() ->
            {
                widthHolder.set(textWidth + 40);
            });
            aGraphics.fillRect(this.x, yHolder.get(), widthHolder.get(), this.height);
            this.yList.add(yHolder.get());
            this.widthList.add(widthHolder.get());
            aGraphics.setColor(this.colorDictionary.get(1));
            aGraphics.drawString(this.subjects.get(indexHolder.get()), this.x + 20, yHolder.get() + this.height / 2);
            indexHolder.set(indexHolder.get() + 1);
        });
        return;
    }

    /**
     * 色のインスタンスをまとめるマップを初期化(して固定)する。
     */
    private void initColorDictionary()
    {
        this.colorDictionary.put(1, new Color(0, 0, 0));
        this.colorDictionary.put(2, new Color(255, 255, 204));
        return;
    }

    /**
     * 自身が持つx座標を応答する
     * @return x座標
     */
    public Integer getX()
    {
        return this.x;
    }

    /**
     * 自身が持つy座標を応答する
     * @param index yListのインデックス
     * @return y座標
     */
    public Integer getY(int index)
    {
        return this.yList.get(index);
    }

    /**
     * フィールドのy座標を応答する。
     * @return y座標
     */
    public List<Integer> getY()
    {
        return this.yList;
    }

    /**
     * 自身が持つy座標を応答する
     * @param index widthListのインデックス
     * @return 横幅
     */
    public Integer getWidth(int index)
    {
        return this.widthList.get(index);
    }

    /**
     * フィールドの横幅を応答する。
     * @return 横幅
     */
    public List<Integer> getWidth()
    {
        return this.widthList;
    }

    /**
     * フィールドに束縛されている高さ(height)を応答する。
     * @return height
     */
    public Integer getHeight()
    {
        return this.height;
    }

    /**
     * 自身を文字列にして応答するメソッド。
     * @return 自身の文字列
     */
    public String toString()
    {
        Class<?> aClass = this.getClass();
        StringBuffer aBuffer = new StringBuffer();

        aBuffer.append(aClass.getName());
        aBuffer.append("[x=");
        aBuffer.append(this.x);
        aBuffer.append("[,y=");
        aBuffer.append(this.yList.toString());
        aBuffer.append("[,width=");
        aBuffer.append(this.widthList.toString());
        aBuffer.append("[,height=");
        aBuffer.append(this.height);
        aBuffer.append(",colordictionary=");
        aBuffer.append(this.colorDictionary.toString());
        aBuffer.append(",font=");
        aBuffer.append(this.font.toString());
        aBuffer.append("]");

        return aBuffer.toString();
    }
}
