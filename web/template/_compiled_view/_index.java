import java.io.OutputStream;
import com.firefly.template.support.ObjectNavigator;
import com.firefly.template.Model;
import com.firefly.template.view.AbstractView;
import com.firefly.template.TemplateFactory;
import com.firefly.template.FunctionRegistry;

public class _index extends AbstractView {

	public _index(TemplateFactory templateFactory){this.templateFactory = templateFactory;}

	@Override
	protected void main(Model model, OutputStream out) throws Throwable {
		ObjectNavigator objNav = ObjectNavigator.getInstance();
		out.write(_TEXT_0);
		out.write(objNav.getValue(model ,"hello").getBytes("UTF-8"));
		out.write(_TEXT_1);
		out.write(objNav.getValue(model ,"info[0]").getBytes("UTF-8"));
		out.write(_TEXT_2);
		out.write(objNav.getValue(model ,"info[1]").getBytes("UTF-8"));
		out.write(_TEXT_3);
	}

	private final byte[] _TEXT_0 = str2Byte("<!DOCTYPE html>\n<html>\n<head>\n<title>", "UTF-8");
	private final byte[] _TEXT_1 = str2Byte(" 测试一下页面</title>\n<style type=\"text/css\">\n.title{\noverflow: hidden;\ntext-align: center;\n}\n.content {\nwidth: 50em;\noverflow: hidden;\nmargin: 0 auto;\n}\n</style>\n</head>\n<body>\n", "UTF-8");
	private final byte[] _TEXT_2 = str2Byte(",", "UTF-8");
	private final byte[] _TEXT_3 = str2Byte("\n<h1 class=\"title\">闲暇时的遐想</h1>\n<div class=\"content\">\n文/〔俄罗斯〕弗·伊·克里别里\n　  译/陈淑贤\n我一直企盼幸福，却感到这非常遥远，它又如此特殊，可望而不可即，几乎无法获得。殊不知幸福就在我身边，在我背后，它悄然无声，不事张扬。原来，我做的工作，度过的时日，与周围人的和谐共处——幸福就在其中。日复一日，年复一年，流年似水，只有到了回首时才顿悟：这就是幸福，幸福本来就一直与我相伴相随！\n　　人，实质上分为两类：第一类感觉自己是债权人，第二类则感觉自己是债务人。债权人杞人忧天，总是怨天尤人，认为所有的人——儿女、双亲、同事乃至人民——都在某些方面对不起他、亏欠他，造成他生活的不幸，葬送他的个人前程。债务人则经受着另外一种更高的境界，令人羡慕的痛苦：无法偿还亏欠生活、亏欠人民的深情厚谊。我更像债务人。我既不求功名，也不盼利禄，我感到幸福的是能够做一点有益处的事情。\n　　人在很多方面依赖大自然，依赖天气状况。寒冷、阴雨，人对此无能为力，只有等待大自然状态的好转，继续生活。雅库特老人说得好：“寒冷、阴雨——很好！这些过后将出现太阳，将会暖洋洋！”\n　　寻找幸福——微妙而离奇。生活中一味追求功成名就，结果徒劳无益。应该老老实实地生活，接受大自然本身的馈赠。我们常常在遥远的某个地方寻找幸福，我们匆忙追逐转瞬即逝的光束。其实幸福就在身旁，在日常生活之中——达到力所能及的目标，称心的工作，家庭的和谐，亲人的安全无恙。不过，永久的、一成不变的幸福是没有的，幸福有时上升，过一段时间又会下降。下降时或平稳或急骤，甚至会严重跌伤。对这种升降只需耐心度过，好像忍耐恶劣天气或命中注定的其他不测一样。最后，临终时你有权说：“我是幸福的。”\n　　当有人问萧伯纳是否幸福时，他回答说，他幸福是因为没有时间考虑这一点。他的幸福在于工作，在于创作。幸福各式各样，也可划分阶段，犹如昼夜时间一样。如果一切都按大自然规定的那样：适时、适度、无忧、无虑，那么，可以认为，人幸福地度过了一生。\n</div>\n</body>\n</html>\n", "UTF-8");
}