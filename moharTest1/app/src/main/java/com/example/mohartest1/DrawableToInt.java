package com.example.mohartest1;

public class DrawableToInt {

    static int[][] FaceType = {{R.drawable.angled_face, R.drawable.selected_angled_face},
            {R.drawable.curved_face, R.drawable.selected_curved_face},
            {R.drawable.egg_face, R.drawable.selected_egg_face},
            {R.drawable.long_face, R.drawable.selected_long_face},
            {R.drawable.triangle_face, R.drawable.selected_triangle_face}};

    static int[][] HairStyle = {{R.drawable.hairstyle_0, R.drawable.selected_hairstyle_0}, //0삭발
            {R.drawable.hairstyle_1, R.drawable.selected_hairstyle_1}, //1아이비리그
            {R.drawable.hairstyle_2, R.drawable.selected_hairstyle_2}, //2크롭
            {R.drawable.hairstyle_3, R.drawable.selected_hairstyle_3}, //3포마드
            {R.drawable.hairstyle_4, R.drawable.selected_hairstyle_4}, //4리젠트
            {R.drawable.hairstyle_5, R.drawable.selected_hairstyle_5}, //5올백
            {R.drawable.hairstyle_6, R.drawable.selected_hairstyle_6}, //6댄디
            {R.drawable.hairstyle_7, R.drawable.selected_hairstyle_7}, //7가일
            {R.drawable.hairstyle_8, R.drawable.selected_hairstyle_8}, //8시스루
            {R.drawable.hairstyle_9, R.drawable.selected_hairstyle_9}, //9쉼표
            {R.drawable.hairstyle_10, R.drawable.selected_hairstyle_10}, //10가르마
            {R.drawable.hairstyle_11, R.drawable.selected_hairstyle_11}, //11쉐도우
            {R.drawable.hairstyle_12, R.drawable.selected_hairstyle_12}, //12히피
            {R.drawable.hairstyle_13,R.drawable.selected_hairstyle_13}, //13드레드
            {R.drawable.hairstyle_14,R.drawable.selected_hairstyle_14}}; //14장발

    static int[][] FaceTypeWithHair = {{R.drawable.angled_0,R.drawable.angled_1, R.drawable.angled_2, R.drawable.angled_3,
            R.drawable.angled_4, R.drawable.angled_5, R.drawable.angled_6, R.drawable.angled_7, R.drawable.angled_8,
            R.drawable.angled_9, R.drawable.angled_10, R.drawable.angled_11, R.drawable.angled_12, R.drawable.angled_13,
            R.drawable.angled_14},

            {R.drawable.curved_0, R.drawable.curved_1, R.drawable.curved_2, R.drawable.curved_3,
                    R.drawable.curved_4, R.drawable.curved_5, R.drawable.curved_6, R.drawable.curved_7,
                    R.drawable.curved_8, R.drawable.curved_9, R.drawable.curved_10, R.drawable.curved_11,
                    R.drawable.curved_12, R.drawable.curved_13, R.drawable.curved_14},

            {R.drawable.egg_0, R.drawable.egg_1, R.drawable.egg_2, R.drawable.egg_3, R.drawable.egg_4,
                    R.drawable.egg_5, R.drawable.egg_6, R.drawable.egg_7, R.drawable.angled_8,
                    R.drawable.egg_9, R.drawable.egg_10, R.drawable.egg_11, R.drawable.egg_12,
                    R.drawable.egg_13, R.drawable.egg_14},

            {R.drawable.long_0, R.drawable.long_1, R.drawable.long_2, R.drawable.long_3, R.drawable.long_4,
                    R.drawable.long_5, R.drawable.long_6, R.drawable.long_7, R.drawable.long_8, R.drawable.long_9,
                    R.drawable.long_10, R.drawable.long_11, R.drawable.long_12, R.drawable.long_13, R.drawable.long_14},

            {R.drawable.triangle_0, R.drawable.triangle_1, R.drawable.triangle_2, R.drawable.triangle_3,
                    R.drawable.triangle_5, R.drawable.triangle_3, R.drawable.triangle_6, R.drawable.triangle_7,
                    R.drawable.triangle_8, R.drawable.triangle_9, R.drawable.triangle_10, R.drawable.triangle_11, R.drawable.triangle_12,
                    R.drawable.triangle_13, R.drawable.triangle_14}};

    static int[][] HairType = {{R.drawable.hairtype_1, R.drawable.selected_hairtype_1},
            {R.drawable.hairtype_2, R.drawable.selected_hairtype_2},
            {R.drawable.hairtype_3, R.drawable.selected_hairtype_3}};

    static String[] HairStyleName = {"삭발", "아이비리그", "크롭", "포마드", "리젠트", "올백", "댄디", "가일", "시스루", "쉼표", "가르마", "쉐도우", "히피", "드레드", "장발"};

    static String[] FaceTypeName = {"각진형", "둥근형", "계란형", "길다란형", "삼각형"};

    static String[] HairTypeName={"직모","반곱슬","곱슬"};

    static String[] HairStyleExplain = {"머리카락을 밀어서 아주 짧게 하거나 두피가 드러나게 만든 헤어 스타일",
                                        "반삭과 비슷한 길이로 만들지만 위, 앞머리는 약간 길게 남긴 헤어 스타일",
                                        "옆머리와 뒷머리를 짧게 정리하고 앞머리를 조금 남겨 볼륨을 더한 헤어 스타일",
                                        "2대8 가르마에 앞머리 볼륨이 있고,그 볼륨이 뒤로 넘어가는 헤어 스타일",
                                        "앞 머리카락을 높이 위로 빗어 넘기고, 옆 머리카락을 뒤로 빗어 붙인 헤어 스타일",
                                        "앞머리를 뒤로 넘겨 이마를 훤하고 시원하게 드러내 보이는 헤어스타일",
                                        "앞머리는 눈썹, 윗머리는 아래로 내려오고 구레나룻은 길지 않으면서 옆머리는 귀를 덮지 않고, 뒷머리는 짧게 한 헤어스타일",
                                        "반쪽은 포마드로 볼륨을 뒤로 넘기고 반쪽은 가르마로 앞머리를 내린 헤어 스타일",
                                        "앞머리 사이사이로 이마가 보일 정도로 숱을 듬성듬성 적게 내린 헤어 스타일",
                                        "가르마 스타일 중 하나로 앞머리를 6:4, 8:2로 나누고 앞머리를 부드럽게 곡선을 내려 쉼표모양을 만든 헤어 스타일",
                                        "앞머리를 좌우로 나눈 헤어스타일",
                                        "컬의 흐름이 잡혀있어 개성 있는 이미지를 만드며 볼륨감을 주는 헤어 스타일",
                                        "컬의 흐름이 매우 많고, 불규칙하며, 부스스한 느낌으로 자유분방한 느낌을 주는 헤어 스타일",
                                        "머리카락을 여러 가닥으로 땋아 늘어 뜨린 헤어 스타일",
                                        "손질없이 자연스럽게 늘어트린 헤어 스타일"};


    }
