package com.example.mohartest1;

public class DrawableToInt {

    static int[][] FaceType = {{R.drawable. angled_face, R.drawable.selected_angled_face},
            {R.drawable.curved_face, R.drawable.selected_curved_face},
            {R.drawable.egg_face, R.drawable.selected_egg_face},
            {R.drawable.long_face, R.drawable.selected_long_face},
            {R.drawable.triangle_face, R.drawable.selected_triangle_face}};

    static int[][] HairStyle = {{R.drawable.down,R.drawable.up}, //0삭발
            {R.drawable.down,R.drawable.up}, //1아이비리그
            {R.drawable.hairstyle_3, R.drawable.selected_hairstyle_3}, //2크롭
            {R.drawable.hairstyle_2, R.drawable.selected_hairstyle_2}, //3포마드
            {R.drawable.hairstyle_1, R.drawable.selected_hairstyle_1}, //4리젠트
            {R.drawable.down,R.drawable.up}, //5올백
            {R.drawable.down,R.drawable.up}, //6댄디
            {R.drawable.hairstyle_4, R.drawable.selected_hairstyle_4}, //7가일
            {R.drawable.hairstyle_6, R.drawable.selected_hairstyle_6}, //8시스루
            {R.drawable.down,R.drawable.up}, //9쉼표
            {R.drawable.hairstyle_5,R.drawable.selected_hairstyle_5}, //10가르마
            {R.drawable.down,R.drawable.up}, //11쉐도우
            {R.drawable.down,R.drawable.up}, //12히피
            {R.drawable.hairstyle_8,R.drawable.selected_hairstyle_8}, //13드레드
            {R.drawable.hairstyle_7,R.drawable.selected_hairstyle_7}}; //14장발

    static int[][] FaceTypeWithHair = {{R.drawable.angled_1, R.drawable.angled_2, R.drawable.angled_3,
            R.drawable.angled_4, R.drawable.angled_5, R.drawable.angled_6, R.drawable.angled_7, R.drawable.angled_8,
            R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2,
            R.drawable.angled_2, R.drawable.angled_2},

            {R.drawable.curved_1, R.drawable.curved_2, R.drawable.curved_3, R.drawable.curved_4,
                    R.drawable.curved_5, R.drawable.curved_6, R.drawable.curved_7, R.drawable.curved_8,
                    R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2,
                    R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2},

            {R.drawable.egg_1, R.drawable.egg_2, R.drawable.egg_3, R.drawable.egg_4, R.drawable.egg_5,
                    R.drawable.egg_6, R.drawable.egg_7, R.drawable.egg_8, R.drawable.angled_2,
                    R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2,
                    R.drawable.angled_2, R.drawable.angled_2},

            {R.drawable.long_1, R.drawable.long_2, R.drawable.long_3, R.drawable.long_4, R.drawable.long_5,
                    R.drawable.long_6, R.drawable.long_7, R.drawable.long_8, R.drawable.angled_2, R.drawable.angled_2,
                    R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2},

            {R.drawable.triangle_1, R.drawable.triangle_2, R.drawable.triangle_3, R.drawable.triangle_4,
                    R.drawable.triangle_5, R.drawable.triangle_6, R.drawable.triangle_7, R.drawable.triangle_8,
                    R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2, R.drawable.angled_2,
                    R.drawable.angled_2, R.drawable.angled_2}};

    static int[][] HairType = {{R.drawable.hairtype_1, R.drawable.selected_hairtype_1},
            {R.drawable.hairtype_2, R.drawable.selected_hairtype_2},
            {R.drawable.hairtype_3, R.drawable.selected_hairtype_3}};

    static String[] HairStyleName = {"삭발", "아이비리그", "크롭", "포마드", "리젠트", "올백", "댄디", "가일", "시스루", "쉼표", "가르마", "쉐도우", "히피", "드레드", "장발"};

    static String[] FaceTypeName = {"각진형", "둥근형", "게란형", "길다란형", "삼각형"};

    static String[] HairTypeName={"직모","반곱슬","곱슬"};

    }
