package test.com.zh.rxandroidlogin.java_test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 创建日期：2019/3/28
 * 描述:
 *
 * @author: zhaoh
 */
public class TestJava {


    /**
     *  1.Map不是collection的子接口或者实现类。Map是一个接口。
     * 2.Map 的 每个 Entry 都持有两个对象，也就是一个键一个值，Map 可能会持有相同的值对象但键对象必须是唯一的。
     *
     *4. Map 里你可以拥有随意个 null 值但最多只能有一个 null 键。
     * 5.Map 接口最流行的几个实现类是 HashMap、LinkedHashMap、Hashtable 和 TreeMap。（HashMap、TreeMap最常用）
     *
     * @param args
     */

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "DaHa");
        map.put("2", "ErHa");
        map.put("3", "DaShaGua");
        map.put("4","大傻子");
        map.put("3","大傻子");
        map.put(null,"二傻子");
        map.put(null,null);
        map.put("8",null);
        map.put("9",null);
        map.put("10",null);
        // 1.通过获取map的key;
        Set<String> set = map.keySet();
        for (String key:map.keySet()){
            String value = map.get(key);
            System.out.println("key=="+key+";value=="+value);
        }

        // 2.通过迭代器循环获取map的值
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("迭代的方式拿到的key=="+next.getKey()+";value=="+next.getValue());
        }

        // 3. Map集合循环遍历方式三 推荐，尤其是容量大时  (通过entrySet方式)
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String,String> entry:entries){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("通过entrySet方式获取Map.Entry<Key,Value>此时 key=="+key+";value=="+value);
        }

        // 第四种：只是得到value的值：
        Collection<String> values = map.values();

        for (String value:values){
            System.out.println("第四种map.values遍历获取value=="+value);
        }


    }
}
