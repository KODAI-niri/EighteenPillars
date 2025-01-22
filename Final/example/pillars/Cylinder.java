package example.pillars;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 柱のうち、円柱のデータを保持し、それを描くクラスである。
 */
public class Cylinder extends Object
{
    /**
     * 円柱を描くのに必要な(一番左上の)x座標を記憶するフィールドである。
     */
    private Integer x;

    /**
     * 円柱を描くのに必要な(一番左上の)y座標を記憶するフィールドである。
     */
    private Integer y;

    /**
     * 円柱の幅を記憶するフィールドである。
     */
    private Integer width;

    /**
     * 円柱の高さを記憶するフィールドである。
     */
    private Integer height;

    /**
     * 複数の色の情報を、整数による単写で束縛しているマップ(辞書)である。
     */
    private Map<Integer, Color> colorDictionary;

    /**
     * 教科課程を描くのに必要なフォントの情報を束縛するフィールドである。
     */
    private Font font;

    /**
     * 18個あるうちの一つの教科課程を束縛するフィールド
     */
    private String computingCorricula;

    /**
     * y座標の差分をまとめたリスト
     */
    private List<Integer> ySubstractionList;

    /**
     * 高さの差分をまとめたリスト
     */
    private List<Integer> heightSubstractionList;

    /**
     * 円柱のコンストラクタ。
     * @param x 円柱の一番左上のx座標
     * @param y 円柱の一番左上のy座標
     * @param width 円柱の横幅
     * @param height 円柱の縦幅
     * @param font フォントのインスタンス
     * @param computingCorricula 教科過程
     * @param ySubstractionList y座標の差分をまとめたリスト
     * @param heightSubstractionList 高さの差分をまとめたリスト
     */
    public Cylinder(Integer x, Integer y, Integer width, Integer height,
                    Font font, String computingCorricula,
                    List<Integer> ySubstractionList, List<Integer> heightSubstractionList)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colorDictionary = new HashMap<Integer, Color>();
        this.initColorDictionary();
        this.font = font;
        this.computingCorricula = computingCorricula;
        this.ySubstractionList = ySubstractionList;
        this.heightSubstractionList = heightSubstractionList;
        return;
    }

    /**
     * 円柱を描くメソッド
     * @param aGraphics グラフィクスコンテキスト
     */
    public void drawCylinder(Graphics aGraphics)
    {
        aGraphics.setColor(this.colorDictionary.get(2));
        aGraphics.fillRect(this.x, this.y, this.width, this.height);
        aGraphics.fillOval(this.x, this.y - this.ySubstractionList.get(0), this.width, this.height - this.heightSubstractionList.get(0));
        aGraphics.fillOval(this.x, this.y - this.ySubstractionList.get(1), this.width, this.height - this.heightSubstractionList.get(1));
        aGraphics.setColor(this.colorDictionary.get(1));
        aGraphics.setFont(this.font);
        Integer stringX = this.x + (this.width / 2) - 15;
        Integer stringY = this.y + (this.height / 2) + 40;
        aGraphics.drawString(this.computingCorricula, stringX, stringY);
        return;
    }

    /**
     * 自身が持つカラーディクショナリを初期化(して固定)するメソッド。
     */
    private void initColorDictionary()
    {
        this.colorDictionary.put(1, new Color(0, 0, 0));
        this.colorDictionary.put(2, new Color(255, 100, 100));
        return;
    }

    /**
     * 自身が持つ円柱の一番左上のx座標を応答する
     * @return 円柱の一番左上のx座標
     */
    public Integer getX()
    {
        return this.x;
    }

    /**
     * 自身が持つ円柱の一番左上のy座標を応答する。
     * @return 円柱の一番左上のy座標
     */
    public Integer getY()
    {
        return this.y;
    }

    /**
     * 円柱の横幅を応答する
     * @return 円柱の横幅
     */
    public Integer getWidth()
    {
        return this.width;
    }

    /**
     * 円柱の高さを応答する
     * @return 円柱の高さ
     */
    public Integer getHeight()
    {
        return this.height;
    }

    /**
     * インデックスに対応するy差分を応答する。
     * @param index インデックス
     * @return y差分
     */
    public Integer getSubstractionY(int index)
    {
        return this.ySubstractionList.get(index);
    }

    /**
     * インデックスに対応するheight差分を応答する。
     * @param index インデックス
     * @return 高さの差分
     */
    public Integer getSubstractionHeight(int index)
    {
        return this.heightSubstractionList.get(index);
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
        aBuffer.append(this.y);
        aBuffer.append("[,width=");
        aBuffer.append(this.width);
        aBuffer.append("[,height=");
        aBuffer.append(this.height);
        aBuffer.append(",colordictionary=");
        aBuffer.append(this.colorDictionary.toString());
        aBuffer.append(",font=");
        aBuffer.append(this.font.toString());
        aBuffer.append(",computingcorricula=");
        aBuffer.append(this.computingCorricula);
        aBuffer.append("]");

        return aBuffer.toString();
    }
}
