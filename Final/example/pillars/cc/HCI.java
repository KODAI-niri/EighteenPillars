package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるHCI(ヒューマンコンピュータインタラクション)を描くクラス
 */
public class HCI extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public HCI()
    {
        super(17);
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
                        "HCI", ySubstractionList, heightSubstractionList);
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
        subjects.add("ヒューマンインタフェース：棟方　渚");
        subjects.add("デジタルファブリケーション：伊藤　慎一郎・永谷　直久");
        subjects.add("ブレインマシンインタフェース：赤崎・伊藤・奥田・田中");
        subjects.add("情報理工学実験A・B テーマ7：奥田　次郎・田中　宏喜");
        subjects.add("神経科学I・II：伊藤　浩之・奥田　次郎・田中　宏喜");
        subjects.add("脳生体情報計測：赤崎　孝文");
        subjects.add("ユーザインタフェース設計：棟方　渚");
        subjects.add("プロジェクト演習　生体計測：赤崎　孝文");
        subjects.add("プロジェクト演習　VRインタフェース開発：永谷　直久");
        subjects.add("感性工学：荻野　晃大");
        subjects.add("インタラクションデザイン論：伊藤　慎一郎・平井　重行");
        subjects.add("特別研究I・II：赤崎　孝文");
        subjects.add("特別研究I・II：荻野　晃大");
        subjects.add("特別研究I・II：永谷　直久");
        subjects.add("特別研究I・II：水口　充");
        subjects.add("特別研究I・II：棟方　渚");
        subjects.add("特別研究I・II：伊藤　慎一郎");
        super.setSubject(340, 25, new Font("Arial", Font.PLAIN, 12), 45, subjects);
        return;
    }
}
