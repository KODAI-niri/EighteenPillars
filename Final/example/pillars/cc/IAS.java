package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるIAS(情報セキュリティ)を描くクラス
 */
public class IAS extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public IAS()
    {
        super(5);
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
        super.setArrow(300, 370, new int[]{370, 370, 400});
        return;
    }

    /**
     * 自身の親クラスのフィールドにCylinderクラスのインスタンスを縛らせる。
     */
    public void setCylinder()
    {
        List<Integer> ySubstractionList = new ArrayList<Integer>();
        ySubstractionList.add(50);
        ySubstractionList.add(-1 * 250);

        List<Integer> heightSubstractionList = new ArrayList<Integer>();
        heightSubstractionList.add(200);
        heightSubstractionList.add(200);

        super.setCylinder(100, 200, 170, 300, new Font("Arial", Font.PLAIN, 24),
                        "IAS", ySubstractionList, heightSubstractionList);
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
        subjects.add("情報セキュリティ基礎：秋山・石原・小林　和真");
        subjects.add("産業システムセキュリティ：秋山・石原・小林　和真");
        subjects.add("情報セキュリティ特別講義：秋山・石原・小林　和真");
        subjects.add("実践情報セキュリティ：秋山・石原・小林　和真");
        subjects.add("特別研究I・II：小林　和真");
        super.setSubject(410, 40, new Font("Arial", Font.PLAIN, 18), 80, subjects);
        return;
    }
}
