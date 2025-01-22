package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるCN(計算科学)を描くクラス
 */
public class CN extends Pillar implements ComputingCurricula
{
    /**
     * コンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public CN()
    {
        super(9);
        this.setCylinder();
        this.setSubject();
        this.setArrow();
        this.setOutLine();
        return;
    }

    /**
     * 自身の親に頼って、柱を描いてもらう。
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
        super.setArrow(250, 350, new int[]{350, 350, 380});
        return;
    }

    /**
     * 自身の親クラスのフィールドにCylinderクラスのインスタンスを縛らせる。
     */
    public void setCylinder()
    {
        List<Integer> ySubstractionList = new ArrayList<Integer>();
        ySubstractionList.add(50);
        ySubstractionList.add(-1 * 600);

        List<Integer> heightSubstractionList = new ArrayList<Integer>();
        heightSubstractionList.add(550);
        heightSubstractionList.add(550);

        super.setCylinder(50, 50, 170, 650, new Font("Arial", Font.PLAIN, 32),
                        "CN", ySubstractionList, heightSubstractionList);
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
        subjects.add("大学数学の基礎演習I・II：鶴谷　直樹");
        subjects.add("微分積分I・II：中川　義行・神　貞介・瀬川　典久");
        subjects.add("線形代数I：結城　郷・赤岩　香苗");
        subjects.add("線形代数II：御手洗　彰・赤岩　香苗");
        subjects.add("多変量解析の初歩：赤岩　香苗");
        subjects.add("微分積分III：赤岩　香苗");
        subjects.add("運動の数学：永谷　直久");
        subjects.add("現象の数学：伊藤　浩之");
        subjects.add("特別研究I：II：赤岩　香苗");
        super.setSubject(400, 40, new Font("Arial", Font.PLAIN, 18), 80, subjects);
        return;
    }
}
