package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるPBD(プラットフォームに依存した開発)を描くクラス
 */
public class PBD extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public PBD()
    {
        super(2);
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
        ySubstractionList.add(-1 * 100);

        List<Integer> heightSubstractionList = new ArrayList<Integer>();
        heightSubstractionList.add(50);
        heightSubstractionList.add(50);

        super.setCylinder(100, 300, 170, 150, new Font("Arial", Font.PLAIN, 24),
                        "PBD", ySubstractionList, heightSubstractionList);
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
        subjects.add("特別研究I・II：小林　聡");
        subjects.add("特別研究I・II：平井　重行");
        super.setSubject(440, 45, new Font("Arial", Font.PLAIN, 18), 150, subjects);
        return;
    }
}
