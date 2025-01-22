package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるSF(システム基礎)を描くクラス
 */
public class SF extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタを生成する。
     * 自身の親クラスのインスタンスを生成する
     */
    public SF()
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
        ySubstractionList.add(-1 * 250);

        List<Integer> heightSubstractionList = new ArrayList<Integer>();
        heightSubstractionList.add(200);
        heightSubstractionList.add(200);

        super.setCylinder(100, 200, 170, 300, new Font("Arial", Font.PLAIN, 24),
                        "SF", ySubstractionList, heightSubstractionList);
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
        subjects.add("コンピュータ概論：荻原　剛志");
        subjects.add("電子回路：赤崎　孝文");
        subjects.add("システム理論：川村　新");
        subjects.add("制御理論：永谷　直久");
        subjects.add("電気回路理論：川村　新");
        super.setSubject(440, 45, new Font("Arial", Font.PLAIN, 18), 80, subjects);
        return;
    }
}
