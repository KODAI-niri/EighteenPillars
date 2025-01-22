package example.pillars.cc;

import example.pillars.Pillar;

import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Pillar(柱を描くクラス)を継承し、
 * 教科課程の一つであるIS(知的システム)を描くクラス
 */
public class IS extends Pillar implements ComputingCurricula
{
    /**
     * このクラスのコンストラクタ。
     * 自身の親のインスタンスを生成する。
     */
    public IS()
    {
        super(15);
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
                        "IS", ySubstractionList, heightSubstractionList);
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
        subjects.add("データ解析の基礎：奥田　次郎");
        subjects.add("機械学習入門：田中　宏喜");
        subjects.add("情報理工学実験A・B　テーマ8：赤崎　孝文・伊藤　浩之");
        subjects.add("自然言語処理：宮森　恒");
        subjects.add("パターン認識と機械学習：宮森 恒");
        subjects.add("プロジェクト演習　AI演習：岡田　英彦");
        subjects.add("プロジェクト演習　データ工学：中島　伸介");
        subjects.add("プロジェクト演習　メディアインタラクション：宮森　恒");
        subjects.add("特別研究I・II：伊藤　浩之");
        subjects.add("特別研究I・II：奥田　次郎");
        subjects.add("特別研究I・II：河合　由起子");
        subjects.add("特別研究I・II：田中　宏喜");
        subjects.add("特別研究I・II：中島　伸介");
        subjects.add("特別研究I・II：宮森　恒");
        subjects.add("特別研究I・II：岡田　英彦");
        super.setSubject(340, 30, new Font("Arial", Font.PLAIN, 14), 50, subjects);
        return;
    }
}
