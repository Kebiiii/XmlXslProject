package com.apecircle.easytranslib.method;

public enum SheetEnum {
    Default("values", "默认/Default", "zh-CN", 36),
    CN_ZH("values-zh-rCN", "简体中文/Chinese", "zh-CN", 36),
    CN_HK("values-zh-rHK", "繁体中文-香港","zh-TW",37),
    CN_TW("values-zh-rTW", "繁体中文-台湾","zh-TW",37),
    EN("values-en", "英语/English","en",9),
    Czech("values-cs-rCZ", "捷克/Czech", "cs", 5),
    Danish("values-da-rDK", "丹麦语/Danish","da",39),
    Dutch("values-nl", "荷兰语/Dutch","nl",24),
    Spanish("values-es", "西班牙语/Spanish","es",11),
    Finnish("values-fi-rFI", "芬兰语/Finnish","fi",13),
    Portuguese("values-pt", "葡萄牙语/Portuguese","pt",28),
    French("values-fr", "法语/French","fr",15),
    Deutsch("values-de-rDE", "德语/Deutsch","de",6),
    Greek("values-el-rGR", "希腊语/Greek","el",40),
    Italian("values-it-rIT", "意大利语/Italian","it",20),
    Japanese("values-ja", "日语/Japanese","ja",22),
    Norwegian("values-nb-rNO", "挪威语/Norwegian","",36),//
    Polish("values-pl-rPL", "波兰语/Polish", "", 26),//
    Romanian("values-ro-rRO", "罗马尼亚语/Romanian","",29),
    Russian("values-ru-rRU", "俄语/Russian","ru",30),
    Swedish("values-sv-rSE", "瑞典语/Swedish","",32),//
    Turkish("values-tr-rTR", "土耳其语/Turkish","",34),
    Arabic("values-ar", "阿拉伯语/Arabic","",1),
    Hungarian("values-hu-rHU", "匈牙利语/Hungarian","",18),
    Thai("values-th-rTH", "泰语/Thai","",33),
    Persian("values-fa", "波斯语/Persian","",36),//
    Vietnamese("values-vi-rVN", "越南语/Vietnamese","",35),
    Korean("values-ko-rKR", "韩语/Korean","ko",23);

    private String valueFileName;//文件夹名称
    private String title;        //对应excel中的标题
    private String code;        //对应excel中语言的翻译语言码
    private int number;        //对应服务器中语言的翻译语言码

    SheetEnum(String valueFileName, String title, String code, int number) {
        this.valueFileName = valueFileName;
        this.title = title;
        this.code = code;
        this.number = number;
    }

    public static SheetEnum getLanByFolderName(String folderName) {
        for (SheetEnum sheetEnum : values()) {
            if (sheetEnum.valueFileName.equals(folderName)) {
                return sheetEnum;
            }
        }
        return SheetEnum.Default;
    }

    public String getValueFileName() {
        return valueFileName;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public int getNumber() {
        return number;
    }
}
