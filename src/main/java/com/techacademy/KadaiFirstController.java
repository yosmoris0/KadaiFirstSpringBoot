package com.techacademy;

    import java.text.SimpleDateFormat;
    import java.util.Calendar;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class KadaiFirstController {

        // 仕様1-指定日の曜日を算定する(http://localhost:8080/dayofweek/20230225)
        @GetMapping("/dayofweek/{yyyymmdd}")
        public String dispDayOfWeek(@PathVariable String yyyymmdd) {

            try{
                //曜日配列
                String yobi[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

                //フォーマット指定＆日付チェック
                SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
                sdf.setLenient(false);
                sdf.parse(yyyymmdd);

                //年・月・日を取得する
                int y = Integer.parseInt(yyyymmdd.substring(0,4));
                int m = Integer.parseInt(yyyymmdd.substring(4,6))-1;
                int d = Integer.parseInt(yyyymmdd.substring(6,8));
                Calendar cal = Calendar.getInstance();
                cal.set(y, m, d);

                //曜日を特定する
                return "実行結果：" + (yobi[cal.get(Calendar.DAY_OF_WEEK)-1]);

            }catch(Exception e){
                return null;
            }
        }

        // 仕様2-四則演算を行なう
        // ---足し算（http://localhost:8080/plus/6/3）---
        @GetMapping("/plus/{val1}/{val2}")
        public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
            int res = 0;
            res = val1 + val2;
            return "実行結果：" + res;
        }

        // ---引き算（http://localhost:8080/minus/6/3）---
        @GetMapping("/minus/{val1}/{val2}")
        public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
            int res = 0;
            res = val1 - val2;
            return "実行結果：" + res;
        }

        // ---掛け算（http://localhost:8080/times/6/3）---
        @GetMapping("/times/{val1}/{val2}")
        public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
            int res = 0;
            res = val1 * val2;
            return "実行結果：" + res;
        }

        // ---割り算（http://localhost:8080/divide/6/3）---
        @GetMapping("/divide/{val1}/{val2}")
        public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
            int res = 0;
            res = val1 / val2;
            return "実行結果：" + res;
        }

}