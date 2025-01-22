package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるSE(ソフトウェア工学)を描くクラス
 */
public class SE extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親クラスのインスタンスを生成する。
     */
    public SE()
    {
        super(6);
        this.setCylinder();
        this.setSubject();
        this.setArrow();
        this.setOutLine();
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
        ySubstractionList.add(-1 * 350);

        List<Integer> heightSubstractionList = new ArrayList<Integer>();
        heightSubstractionList.add(300);
        heightSubstractionList.add(300);

        super.setCylinder(100, 200, 170, 400, new Font("Arial", Font.PLAIN, 24),
                        "SE", ySubstractionList, heightSubstractionList);
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
        subjects.add("ソフトウェア工学I：玉田　春昭");
        subjects.add("ソフトウェア工学II：青木　淳");
        subjects.add("プロジェクト演習 アプリケーション開発：青木　淳");
        subjects.add("特別研究I・II：青木　淳");
        subjects.add("特別研究I・II：玉田　春昭");
        subjects.add("特別研究I・II：荻原　剛志");
        super.setSubject(440, 45, new Font("Arial", Font.PLAIN, 18), 80, subjects);
        return;
    }
}
