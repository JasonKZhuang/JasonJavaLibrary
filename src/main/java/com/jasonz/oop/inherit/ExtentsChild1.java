package com.jasonz.oop.inherit;


/**
 * @creator Jason Zhuang
 * @create-time 2013-6-25
 * è¯¥ç±»ä¸»è¦�ä½“çŽ°ç»§æ‰¿å¯¹çˆ¶ç±»æ–¹æ³•çš„è¦†ç›–æˆ–é‡�è½½
 * copywrite kkcms.com
 */
public class ExtentsChild1 extends ExtentsParent
{

	public int pubChildVal=1;
	
	protected int proChildVal=2;
	
	int    pagChildVal = 3;
	
	private   int priChildVal=4;
	
	public String pubChildMethod()
	{
		System.out.println( "This is the Child PUBLIC Method");
		return "";
	}
	
	protected String proChildMethod()
	{
		System.out.println( "This is the Child PROTECTED Method");
		return "";
	}
	
	String pagChildMethod()
	{
		System.out.println( "This is the Child PACKAGE Method");
		return "";
	}
	
	private String priChildMethod()
	{
		System.out.println(  "This is the Child PRIVATE Method");
		return "";
	}
	
	//è¦†ç›–-ã€‹å­�ç±»çš„æ–¹æ³•å��ï¼Œå�‚æ•°ç­¾å��å’Œè¿”å›žç±»åž‹å¿…é¡»ä¸Žçˆ¶äº²ç›¸å�Œ
	@Override
	public int  draw()
	{
		System.out.println("This is Child Method draw use to Override!");
		this.pubParentVal = 100;
		System.out.println("This is Child Method set pubParentVal = 100");
		return 0;
	}
	
	//è¦†ç›–-ã€‹å­�ç±»çš„æ–¹æ³•ä¸�èƒ½ç¼©å°�çˆ¶ç±»çš„è®¿é—®æ�ƒé™�
	@Override
	public int  write()
	{
		System.out.println("This is Child Method write use to Override!");
		return 0;
	}
	
	//è¦†ç›–-ã€‹å­�ç±»æ–¹æ³•è¦†ç›–çˆ¶ç±»æ–¹æ³•ï¼ŒæŠ›å‡ºå¼‚å¸¸ä¸�èƒ½æ¯”çˆ¶ç±»å¤š
	@Override
	public int  exceptiontest() throws Exception
	{
		System.out.println("This is Child Method exceptiontest use to Override!");
		return 0;
	}
	
	//éš�è—�çˆ¶ç±»é�™æ€�æ–¹æ³•-ã€‹å­�ç±»æ–¹æ³•è¦†ç›–çˆ¶ç±»é�™æ€�æ–¹æ³•
	public static int  staticMethodTest()
	{
		System.out.println("This is Child static Method use to Override!");
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ExtentsChild1 sub = new ExtentsChild1();
		sub.pubParentMethod();
		sub.pubChildMethod();
		sub.proParentMethod();
		sub.proChildMethod();
		sub.priChildMethod();
		//è°ƒç”¨æ–¹æ³•é‡�è½½
		System.out.println("call parent max method value="+sub.max(1, 2));
		System.out.println("call parent max method value="+sub.max(1.6f, 1.5f));
		
		ExtentsParent parent = new ExtentsChild1();
		//è°ƒç”¨çˆ¶ç±»æ–¹æ³•è¦†ç›–
		parent.draw();
		//sub.draw();
		parent.write();
		//sub.write();
		//sub.exceptiontest();		
		//è°ƒç”¨é�™æ€�æ–¹æ³•
		parent.staticMethodTest();
		sub.staticMethodTest();
		
	}

}

