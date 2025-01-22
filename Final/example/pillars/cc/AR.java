package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるAR(アーキテクチャと構成)を描くクラス
 */
public class AR extends Pillar implements ComputingCurricula
{
    /**
     * コンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public AR()
    {
        super(11);
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
        super.setArrow(230, 290, new int[]{290, 290, 320});
        return;
    }

    /**
     * 自身の親クラスのフィールドにCylinderクラスのインスタンスを縛らせる。
     */
    public void setCylinder()
    {
        List<Integer> ySubstractionList = new ArrayList<Integer>();
        ySubstractionList.add(50);
        ySubstractionList.add(-1 * 650);

        List<Integer> heightSubstractionList = new ArrayList<Integer>();
        heightSubstractionList.add(600);
        heightSubstractionList.add(600);
        super.setCylinder(50, 50, 170, 700, new Font("Arial", Font.PLAIN, 30), 
                        "AR", ySubstractionList, heightSubstractionList);
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
        subjects.add("論理回路I：新實　治男");
        subjects.add("論理回路II：吉村　正義");
        subjects.add("情報理工学実験A・B テーマ1：新實　治男・大元　英徹");
        subjects.add("情報理工学実験A・B テーマ4：川村　新・吉村　正義");
        subjects.add("コンピュータアーキテクチャI・II：新實　治男");
        subjects.add("センサと計測：永谷　直久");
        subjects.add("組み込みハードウェア設計：川村　新");
        subjects.add("システムLSI設計：吉村　正義");
        subjects.add("特別研究I・II：川村　新");
        subjects.add("特別研究I・II：吉村　正義");
        subjects.add("特別研究I・II：新實　治男");
        super.setSubject(340, 35, new Font("Arial", Font.PLAIN, 18), 70, subjects);
        return;
    }
}
