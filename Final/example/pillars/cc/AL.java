package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるAL(アルゴリズムと計算量)を描くクラス
 */
public class AL extends Pillar implements ComputingCurricula
{
    /**
     * コンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public AL()
    {
        super(3);
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
        ySubstractionList.add(-1 * 150);

        List<Integer> heightSubstractionList = new ArrayList<Integer>();
        heightSubstractionList.add(100);
        heightSubstractionList.add(100);

        super.setCylinder(100, 200, 170, 200, new Font("Arial", Font.PLAIN, 24),
                        "AL", ySubstractionList, heightSubstractionList);
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
        subjects.add("アルゴリズムとデータ構造：井上　博之");
        subjects.add("数値計算：小林　聡");
        subjects.add("最適化理論：小林　聡");
        super.setSubject(440, 45, new Font("Arial", Font.PLAIN, 18), 100, subjects);
        return;
    }
}
