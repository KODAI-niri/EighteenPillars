package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるNC(ネットワークと構造)を描くクラス
 */
public class NC extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public NC()
    {
        super(13);
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
        super.setArrow(230, 320, new int[]{320, 320, 350});
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
                        "NC", ySubstractionList, heightSubstractionList);
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
        subjects.add("コンピュータネットワークI：大元　英徹");
        subjects.add("情報理工学実験A・B　テーマ2：岡田　英彦・瀬川　典久");
        subjects.add("情報理工学実験A・B　テーマ5：秋山　豊和・林原　尚浩");
        subjects.add("コンピュータネットワークII：秋山　豊和");
        subjects.add("信号処理基礎：瀬川　典久");
        subjects.add("情報理論：岡田　英彦");
        subjects.add("デジタル信号処理：平井　重行");
        subjects.add("音響メディア論：平井　重行");
        subjects.add("電磁波情報学：瀬川　典久");
        subjects.add("特別研究I・II：秋山　豊和");
        subjects.add("特別研究I・II：瀬川　典久");
        subjects.add("特別研究I・II：安田　豊");
        subjects.add("特別研究I・II：井上　博之");
        super.setSubject(370, 40, new Font("Arial", Font.PLAIN, 16), 60, subjects);
        return;
    }
}
