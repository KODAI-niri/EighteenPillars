package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるSDF(ソフトウェア開発基礎)を描くクラス
 */
public class SDF extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public SDF()
    {
        super(15);
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
                        "SDF", ySubstractionList, heightSubstractionList);
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
        subjects.add("基礎プログラミング演習I<a>：永谷　直久・水口　充");
        subjects.add("基礎プログラミング演習I<b>：蚊野　浩・井上　由起子");
        subjects.add("基礎プログラミング演習I<c>：井上　博之・棟方　渚");
        subjects.add("基礎プログラミング演習I<d>：荻野　晃大・中島　伸介");
        subjects.add("基礎プログラミング演習II<a,b,c,d>：安田・荻野・井上・吉村");
        subjects.add("情報理工学実験A・B：テーマ6：河合　由起子・棟方　渚");
        subjects.add("発展プログラミング演習<a,b>：玉田　春昭・宮森　恒");
        subjects.add("応用プログラミング(アルゴリズム)：鴨　浩靖");
        subjects.add("応用プログラミング(C)：井上　博之");
        subjects.add("応用プログラミング(Java)：青木　淳");
        subjects.add("応用プログラミング(Python)：青木　淳");
        subjects.add("応用プログラミング(Web)：河合　由起子");
        subjects.add("応用プログラミング(データ解析)：荻野　晃大");
        subjects.add("実践Webテクノロジ：河合　由起子");
        subjects.add("プロジェクト演習：C言語によるプログラム開発：荻原　剛志");
        super.setSubject(340, 30, new Font("Arial", Font.PLAIN, 14), 50, subjects);
        return;
    }
}
