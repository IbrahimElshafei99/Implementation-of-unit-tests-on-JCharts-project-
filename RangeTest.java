//ibrahim adel
//20178001
//B1

package org.jfree.data.test;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    @Test
    public void testgetLowerBound(){
        Range obj=new Range(1,10);
        Assert.assertEquals(1,obj.getLowerBound(),0);
    }
    @Test
    public void testgetUpperBound(){
        Range obj=new Range(1,10);
        Assert.assertEquals(10,obj.getUpperBound(),0);
    }
    @Test
    public void testgetLength(){
        Range obj=new Range(1,10);
        Assert.assertEquals(9,obj.getLength(),0);
    }
    @Test
    public void testgetCentralValue(){
        Range obj=new Range(1,3);
        Assert.assertEquals(2,obj.getCentralValue(),0);
    }
    @Test
    public void testcontains(){
        Range obj=new Range(2,10);
        Assert.assertTrue(obj.contains(5));
        Assert.assertTrue(obj.contains(2));
        Assert.assertTrue(obj.contains(10));
        Assert.assertFalse(obj.contains(11));
        Assert.assertFalse(obj.contains(1));
    }
    @Test
    public void testintersects(){
        Range obj=new Range(5,10);
        Assert.assertTrue(obj.intersects(5,10));
        Assert.assertTrue(obj.intersects(4,8));
        Assert.assertTrue(obj.intersects(2,8));
        Assert.assertTrue(obj.intersects(6,12));
        Assert.assertFalse(obj.intersects(1,4));
        Assert.assertFalse(obj.intersects(11,14));
    }
    @Test
    public void testconstrain(){
        Range obj=new Range(5,10);
        Assert.assertEquals(8,obj.constrain(8),0);
        Assert.assertEquals(5,obj.constrain(4),0);
        Assert.assertEquals(10,obj.constrain(11),0);
        Assert.assertEquals(5,obj.constrain(5),0);
        Assert.assertEquals(10,obj.constrain(10),0);
    }
    @Test
    public void testcombine(){
        Range r1=new Range(1,10);
        Range r2=new Range(8,15);
        Range result=Range.combine(r1,r2);
        Range result2=Range.combine(null,r2);
        Range result3=Range.combine(null,null);
        Assert.assertEquals(1,result.getLowerBound(),0);
        Assert.assertEquals(15,result.getUpperBound(),0);
        Assert.assertEquals(8,result2.getLowerBound(),0);
        Assert.assertEquals(15,result2.getUpperBound(),0);
        Assert.assertEquals(null,result3);
    }
    @Test
    public void testexpandToInclude(){
        Range range=new Range(5,10);
        Range result=Range.expandToInclude(range,6);
        Assert.assertEquals(5,result.getLowerBound(),0);
        Assert.assertEquals(10,result.getUpperBound(),0);

        Range result2=Range.expandToInclude(range,11);
        Assert.assertEquals(5,result2.getLowerBound(),0);
        Assert.assertEquals(11,result2.getUpperBound(),0);

        Range result3=Range.expandToInclude(range,4);
        Assert.assertEquals(4,result3.getLowerBound(),0);
        Assert.assertEquals(10,result3.getUpperBound(),0);

        Range result4=Range.expandToInclude(null,6);
        Assert.assertEquals(6,result4.getLowerBound(),0);
        Assert.assertEquals(6,result4.getUpperBound(),0);

    }
    @Test
    public void testexpand(){
        Range range=new Range(2,6);
        Range result=Range.expand(range,0.25,0.5);
        Assert.assertEquals(1,result.getLowerBound(),0);
        Assert.assertEquals(8,result.getUpperBound(),0);
        Assert.assertThrows(IllegalArgumentException.class,()->Range.expand(null,0.25,0.5));
    }
    @Test
    public void testshift(){
        Range range=new Range(2,6);
        Range result=Range.shift(range,3);
        Assert.assertEquals(5,result.getLowerBound(),0);
        Assert.assertEquals(9,result.getUpperBound(),0);
        Assert.assertThrows(IllegalArgumentException.class,()->Range.shift(null,2));
    }
    @Test
    public  void testshift2(){
        Range range=new Range(-1,6);
        Range result=Range.shift(range,3,false);
        Assert.assertEquals(0,result.getLowerBound(),0);
        Assert.assertEquals(9,result.getUpperBound(),0);

        Range result2=Range.shift(range,3,true);
        Assert.assertEquals(2,result2.getLowerBound(),0);
        Assert.assertEquals(9,result2.getUpperBound(),0);
        Assert.assertThrows(IllegalArgumentException.class,()->Range.shift(null,2,true));
    }
    @Test
    public void testequals(){
        Range range=new Range(5,10);
        Range range2=new Range(5,10);
        Range range3=new Range(5,11);
        Range range4=new Range(6,11);
        Assert.assertTrue(range.equals(range2));
        Assert.assertFalse(range.equals(range3));
        Assert.assertFalse(range.equals(range4));
        Assert.assertFalse(range.equals(null));
    }
}
