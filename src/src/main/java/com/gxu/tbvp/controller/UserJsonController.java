package com.gxu.tbvp.controller;

<<<<<<< HEAD
import com.gxu.tbvp.domain.Manager;
import com.gxu.tbvp.service.RegionService;
import com.gxu.tbvp.service.UserService;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.data.repository.query.Param;
=======
import com.gxu.tbvp.service.UserService;
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191

@RestController
@RequestMapping("/userJson")
public class UserJsonController {

<<<<<<< HEAD
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 10l, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));
    LinkedBlockingQueue<Runnable> queue = (LinkedBlockingQueue<Runnable>) executor.getQueue();

    @Resource
    private UserService userService;

    @Resource
    private RegionService regionService;

    @RequestMapping("/getSexJson")
    public Map getSexJson() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final int[] sexs =  {0,1};
        final String[] bgs = "boy,girl".split(",");

        Map sexBG = new HashMap();
        for (int i = 0; i < 2; i++) {
            sexBG.put(bgs[i], sexs[i]);
        }

        Map sexMap = new HashMap();
        for (String bg:bgs) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        sexMap.put(bg, userService.countSex((int)sexBG.get(bg)));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        return sexMap;
    }

    @RequestMapping("/getProvince")
    public ArrayList<Map> test() throws InterruptedException {
        final int[] provinceIds = {110000,120000,130000,140000,150000,210000,220000,230000,310000,320000,330000,340000,350000,360000,370000,410000,420000,430000,440000,450000,460000,500000,510000,520000,530000,540000,610000,620000,630000,640000,650000,710000,810000,820000,990000};
        String[] provinces = "北京,天津,河北,山西,内蒙古,辽宁,吉林,黑龙江,上海,江苏,浙江,安徽,福建,江西,山东,河南,湖北,湖南,广东,广西,海南,重庆,四川,贵州,云南,西藏,陕西,甘肃,青海,宁夏,新疆,台湾,香港,澳门,海外".split(",");
        final CountDownLatch countDownLatch = new CountDownLatch(35);
        Map maps = new HashMap();
        for (int i=0; i<35;i++){
            maps.put(provinces[i],provinceIds[i]);
        }
        ArrayList<Map> maplist = new ArrayList<>();
        for(String province:provinces){
            Map provinceMap = new HashMap();
            executor.execute(new Runnable(){
                public void run() {
                    try {
                        provinceMap.put("name",province);
                        provinceMap.put("value",regionService.selectCountProvinceById((int)maps.get(province)));
                        maplist.add(provinceMap);
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
//                    System.out.println(countDownLatch);
                }
            });
        }
        //所有子线程 执行完成之后 主线程再继续向下
        countDownLatch.await();
        return maplist;
    }

    @RequestMapping("/getUserAge")
    public ArrayList<Map> getUserAge() throws InterruptedException{
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        final String[] agesChi = "12岁以下,12-18岁,18-30岁,30-60岁,60岁以上".split(",");
        final int[] ages = {0,12,18,30,60,90};

        HashMap<String, int[]> hashMap = new HashMap<String, int[]>();
        for (int i = 0; i < ages.length -1; i++) {
            int[] put = {ages[i], ages[i+1]};
            hashMap.put(agesChi[i], put);
        }

        ArrayList<Map> mapArrayList = new ArrayList<>();
        for(String agec:agesChi){
            Map map = new HashMap();
            int temp =0;
            for (String agec1:agesChi){
                if (agec.contains(agec1)){
                    String drilldown = "a" + temp;
                    map.put("drilldown",drilldown);
                }
                temp ++;
            }

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Map<String, Object> map1 = new HashedMap();
                        map1.put("firstAge",(int)hashMap.get(agec)[0]);
                        map1.put("lastAge",(int)hashMap.get(agec)[1]);
                        map.put("name", agec);
                        map.put("y",userService.countAge(map1));
                        mapArrayList.add(map);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();

//        for (int i = 0; i < 5; i++) {
//            System.out.println(mapArrayList.get(i));
//        }
        return mapArrayList;
    }

=======
    @Resource
    private UserService userService;

    @RequestMapping("/getSexJson")
    public Map getSexJson() {
        int countGirl = userService.countSex(1);
        int countBoy = userService.countSex(0);
        System.out.println(countBoy);
        Map sexMap = new HashMap();
        sexMap.put("boy", countBoy);
        sexMap.put("girl", countGirl);
        return sexMap;
    }
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191
}
