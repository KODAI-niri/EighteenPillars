package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるDS(離散構造)を描くクラス
 */
public class DS extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public DS()
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
                        "DS", ySubstractionList, heightSubstractionList);
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
        subjects.add("コンピュータのための数学：小林　聡");
        subjects.add("離散数学：小林　聡");
        subjects.add("確率と統計：濱地　賢太郎");
        subjects.add("言語オートマトン：井上　博之");
        super.setSubject(440, 45, new Font("Arial", Font.PLAIN, 18), 80, subjects);
        return;
    }
}
