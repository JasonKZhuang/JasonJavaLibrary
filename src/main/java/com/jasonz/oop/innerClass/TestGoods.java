package com.jasonz.oop.innerClass;
/**
 * @creator Jason Zhuang
 * @create-time 2013-6-27
 * åœ¨è¿™ä¸ªä¾‹å­�é‡Œç±»Contentå’ŒDestinationè¢«å®šä¹‰åœ¨äº†ç±»Goodså†…éƒ¨ï¼Œ
 * å¹¶ä¸”åˆ†åˆ«æœ‰ç�€protectedå’Œprivateä¿®é¥°ç¬¦æ�¥æŽ§åˆ¶è®¿é—®çº§åˆ«ã€‚
 * Contentä»£è¡¨ç�€Goodsçš„å†…å®¹ï¼Œè€ŒGDestinationä»£è¡¨ç�€Goodsçš„ç›®çš„åœ°ã€‚
 * å®ƒä»¬åˆ†åˆ«å®žçŽ°äº†ä¸¤ä¸ªæŽ¥å�£IContentå’ŒIDestinationã€‚
 * åœ¨å�Žé�¢çš„mainæ–¹æ³•é‡Œï¼Œç›´æŽ¥ç”¨ IContents cå’ŒIDestination dè¿›è¡Œæ“�ä½œï¼Œ
 * ä½ ç”šè‡³è¿žè¿™ä¸¤ä¸ªå†…éƒ¨ç±»çš„å��å­—éƒ½æ²¡æœ‰çœ‹è§�ï¼�
 * è¿™æ ·ï¼Œå†…éƒ¨ç±»çš„ç¬¬ä¸€ä¸ªå¥½å¤„å°±ä½“çŽ°å‡ºæ�¥äº† éš�è—�ä½ ä¸�æƒ³è®©åˆ«äººçŸ¥é�“çš„æ“�ä½œï¼Œä¹Ÿå�³å°�è£…æ€§ã€‚
 * 
 * 2.å†…éƒ¨ç±»çš„ç¬¬äºŒä¸ªå¥½å¤„ ä¸€ä¸ªå†…éƒ¨ç±»å¯¹è±¡å�¯ä»¥è®¿é—®åˆ›å»ºå®ƒçš„å¤–éƒ¨ç±»å¯¹è±¡çš„å†…å®¹ï¼Œç”šè‡³åŒ…æ‹¬ç§�æœ‰å�˜é‡�
 * copywrite kkcms.com
 */
public class TestGoods
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Goods p = new Goods();  
        IContents c    = p.cont();  
        IDestination d = p.dest("Beijing");  
	}

}

