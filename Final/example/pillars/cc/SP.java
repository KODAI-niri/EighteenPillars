package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるSP(社会的視点と情報倫理)を描くクラス
 */
public class SP extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタである。
     * 自身の親クラスのインスタンスを生成する。
     */
    public SP()
    {
        super(4);
        this.setCylinder();
        this.setSubject();
        this.setArrow();
        this.setOutLine();
        return;
    }

    /**
     * 自身の親に頼って、柱を描いてもらう
     * @param aGraphics グラフィクスコンテキスト
     */
    public void drawPillar(Graphics aGraphics)
    {
        super.drawPillar(aGraphics);
        return;
    }

    /**
     * 自身の親クラスのフィールドにArrowクラスのインスタンスを縛らせる。
     */
    public void setArrow()
    {
        super.setArrow(300, 400, new int[]{400, 400, 430});
        return;
    }

    /**
     * 自身の親クラスのフィールドにCylinderクラスのインスタンスを縛らせる。
     */
    public void setCylinder()
    {
        List<Integer> ySubstractionList = new ArrayList<Integer>();
        ySubstractionList.add(50);
        ySubstractionList.add(-1 * 200);

        List<Integer> heightSubstractionList = new ArrayList<Integer>();
        heightSubstractionList.add(150);
        heightSubstractionList.add(150);

        super.setCylinder(100, 200, 170, 250, new Font("Arial", Font.PLAIN, 24),
                        "SP", ySubstractionList, heightSubstractionList);
        return;
    }

    /**
     * 自身の親クラスのフィールドにOutLineクラスのインスタンスを縛らせる。
     */
    public void setOutLine()
    {
        super.setOutLine();
        return;
    }

    /**
     * 自身の親クラスのフィールドにCylinderクラスのインスタンスを縛らせる。
     */
    public void setSubject()
    {
        List<String> subjects = new ArrayList<String>();
        subjects.add("情報リテラシ基礎演習：伊藤　慎一郎・荻野　晃大");
        subjects.add("情報理工学概論：平井　重行");
        subjects.add("技術と社会：蚊野　浩");
        subjects.add("技術英語：川村　新");
        super.setSubject(440, 45, new Font("Arial", Font.PLAIN, 18), 90, subjects);
        return;
    }
}
