package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるGV(グラフィクスと視覚化)を描くクラス
 */
public class GV extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public GV()
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
        super.setArrow(300, 380, new int[]{380, 380, 410});
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
                        "GV", ySubstractionList, heightSubstractionList);
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
        subjects.add("情報理工学実験A・B　テーマ3：蚊野　浩・平井　重行");
        subjects.add("画像処理：蚊野　浩");
        subjects.add("コンピュータグラフィクス：蚊野　浩");
        subjects.add("特別研究I・II：蚊野　浩");
        super.setSubject(410, 45, new Font("Arial", Font.PLAIN, 18), 90, subjects);
        return;
    }
}
