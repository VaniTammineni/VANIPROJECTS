package com.faqs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.faqs.model.Editor;
import com.faqs.model.FileUpload;
//import com.faqs.model.Linux;
import com.faqs.model.Login;
//import com.faqs.model.Unix;
import com.faqs.model.UserForm;
import com.faqs.utils.A2zLogMgr;
@Repository
@Transactional
public class HomePageDaoImplement  implements HomePageDao{
	private final String CLASS_NAME = this.getClass().getCanonicalName();
	@Autowired
	private A2zLogMgr logMgr;

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
		
	}
	@Override
	public void checkDbConnection() {
		try {
//			SQLQuery query = getCurrentSession().createSQLQuery("select count(*) from ainfo");
//
//			System.out.println(query.getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer saveUser(UserForm userform) {
		final String METHOD_NAME = "saveUserDetails";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		Integer status = 0;
		String s = null;
		
		try {
			Session sesison = sessionFactory.getCurrentSession();
			Session session = this.getCurrentSession();
			session.save(userform);
			  status++;
			  
			/*
			 * //userform.setSysId(100); System.out.println(userform.getSysId()); String
			 * fname = userform.getFirstName(); String lname = userform.getLastName();
			 * String uname = userform.getUname(); String userid= userform.getUserid();
			 * String pwd= userform.getPass(); String email= userform.getEmail(); String
			 * mob= userform.getMobileNo(); String landline= userform.getLandLineNo();
			 * String state= userform.getState(); String country= userform.getCountry();
			 * String pincode= userform.getPincode(); String adrs1= userform.getAddress1();
			 * String adrs2= userform.getAddress2(); String userType=
			 * userform.getUserType(); String activuser= userform.getActiveType();
			 */
		/*boolean useridexists = (Long) sesison
				.createQuery("select count(*) from UserForm ud where ud.userid= '" + userid + "'")
				.uniqueResult() > 0;
				
		
		boolean emailexists = (Long) sesison
				.createQuery("select count(*) from UserForm ud where ud.email= '" + email + "'")
				.uniqueResult() > 0;
		boolean mobileexists = (Long) sesison
				.createQuery("select count(*) from UserForm ud where ud.mobileNo= '" + mob + "'")
				.uniqueResult() > 0;
				if(useridexists== false && emailexists==false && mobileexists==false) {*/
					//Session session = this.getCurrentSession();
					//Transaction trans = session.beginTransaction();
			      
					//trans.commit();
				
					//status++;
			/*
			 * } else { System.out.println("Already Existing"); }
			 */
	}catch (Exception e) {
		e.printStackTrace();

	}
	return status;

}
	@Override
	public List<UserForm> listUserDeatails() {
		final String METHOD_NAME = "saveUserDetails";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		Integer status = 0;
		String s = null;
		List<UserForm> list = null;
		
		try {
			Session session = this.getCurrentSession();
			UserForm obj1 = session.get(UserForm.class, 4);
			System.out.println("first hit to db "+obj1);
			UserForm obj2 = session.get(UserForm.class, 4);
			System.out.println("hit to cache but not db "+obj2);
			session.close();
			/*Query q=entityManager.createQuery("select f from Foo f")
			  .setHint("org.hibernate.cacheable", true)
			  .getResultList();*/
			//second cache reetriwal even though session was closed so 2nd level cache scope is session factory not session
			Session ses = sessionFactory.openSession();
			UserForm obj4 = ses.get(UserForm.class, 4);
			System.out.println("get method object retriewal"+obj4);
			//UserForm obj3 = ses.get(UserForm.class, 4);
			//by default 2nd cache is enabled for hibernate methods not for query
	Transaction trans = 	ses.beginTransaction();
			Query q = ses.createQuery("update UserForm u set u.firstName='tammineni'  where u.sysId=4");
			int m = q.executeUpdate();
			System.out.println("updates count is"+m);
			UserForm obj3 = ses.get(UserForm.class,4);
			System.out.println("hit to second cache but not db "+obj3);
			trans.commit();
			ses.close();
			 //First level cache 02-06-2020 
			/*Session session = this.getCurrentSession();
			UserForm userObj = session.get(UserForm.class,4);
			System.out.println("object is"+userObj);
			//UserForm dupuserObj = session.get(UserForm.class,4);
			Query q = session
					.createQuery("select u from UserForm u where u.sysId=4");
			UserForm uf = (UserForm) q.getSingleResult();

			System.out.println("duplicate object is" + uf);
			session.close();
			System.out.println("session closed");
			
			Session session2 = sessionFactory.getCurrentSession();
			//session2.beginTransaction();
			boolean boo = session2.isOpen();
			System.out.println("session2 is opened or not"+boo);
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			UserForm userObj1 = ses.get(UserForm.class,4);
			System.out.println("Second object is"+userObj1);
			ses.getTransaction().commit();
			session2.close();*/
	
			Query query= (Query) session.createCriteria("select * from UserForm ud");
			list = query.getResultList();
			
			
		}catch(Exception e) {
			System.out.println("Exception is"+e);
		}
		return list;
	}
	@Override
	public List<UserForm>  listuser(Login login) {
		final String METHOD_NAME = "saveUserDetails";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		Integer status = 0;
		String s = null;
		List<UserForm> list = null;
		String username = login.getUsername();
		try {
			  
			Session session = this.getCurrentSession();
			Query qry=session.createQuery("select ud from UserForm ud  where ud.userType ='" + username + "'");
			//Query query= (Query) session.createCriteria("select ud from UserForm ud  where ud.userType ='" + username + "'");
			 list = qry.getResultList();
			
		}catch(Exception e) {
			System.out.println("exception handled"+" "+e);
			
		}
		
		return list;
	}
	@Override
	public Integer qustnInsert(Editor obj) {
		final String METHOD_NAME = "saveUserDetails";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		Integer status = 0;
		String s = null;
		
		try {
			Session sesison = sessionFactory.getCurrentSession();
			Session session = this.getCurrentSession();
			session.save(obj);
			  status++;
	}catch (Exception e) {
		e.printStackTrace();

	}
	return status;

	}

	@Override
	public List<Editor> listqustns(Editor ed) {
		final String METHOD_NAME = "saveUserDetails";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		List<Editor> qustnlist = null;
		List<Editor> lists = new ArrayList<Editor>();
		try {
			Session sesison = sessionFactory.getCurrentSession();
			Session session = this.getCurrentSession();
			Query query1 = session.createQuery("select ed  from Editor ed");
			qustnlist = query1.getResultList();

			for (Editor obj : qustnlist) {
				String qus = obj.getQuestion();
				byte[] b = obj.getEditor();
				String a = new String(b);
				// System.out.println(a);
				String q = obj.getQuestion();
				obj.setEditor(b);
				obj.setQuestion(q);
				lists.add(obj);
			}
			/*
			 * byte[] bs = qustnlist.get(0).getEditor(); String s = new
			 * String(bs); System.out.println(s);
			 */

			// System.out.println(qustnlist);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return qustnlist;
	}

	@Override
	public Editor searchqustns(Editor demo) {
		Editor es = null;
		try {

			Session session = this.getCurrentSession();
			String question = demo.getQuestion();
			// System.out.println(question);
			// Query q =
			// sesison.createQuery("select ed from Editor ed where ed.question='"+demo.getQuestion()+"'");
			// es= (Editor) q.getSingleResult();

			// es = (Editor) q.getSingleResult();
			es = session.get(Editor.class, demo.getQustnId());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return es;
	}
	/*
	 * @Override public Integer linuxEditor(Linux obj) { final String METHOD_NAME =
	 * "saveUserDetails"; logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME,
	 * "ENTRY"); int status=0; try { String qus = obj.getlQuestion(); int qid =
	 * obj.getLqustnId(); //Session sesison = sessionFactory.getCurrentSession();
	 * Session session = this.getCurrentSession(); session.save(obj); status++;
	 * }catch (Exception e) { e.printStackTrace();
	 * 
	 * } return status; }
	 * 
	 * @Override public Integer unixEditor(Unix obj) { final String METHOD_NAME =
	 * "saveUserDetails"; logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME,
	 * "ENTRY"); int status=0; try { String qus = obj.getuQuestion(); int qid =
	 * obj.getUqustnId(); //Session sesison = sessionFactory.getCurrentSession();
	 * Session session = this.getCurrentSession(); session.save(obj); status++;
	 * }catch (Exception e) { e.printStackTrace();
	 * 
	 * } return status; }
	 * 
	 * @Override public List<Linux> listLinuxQustn(Linux lin) { final String
	 * METHOD_NAME = "saveUserDetails"; logMgr.writeToLog("INFO", CLASS_NAME,
	 * METHOD_NAME, "ENTRY");
	 * 
	 * List<Linux> linList=null; try { Session session = this.getCurrentSession();
	 * Query query1 = session.createQuery("select lin from Linux lin"); linList =
	 * query1.getResultList();
	 * 
	 * }catch (Exception e) { e.printStackTrace();
	 * 
	 * } return linList; }
	 * 
	 * @Override public List<Unix> listUnixQustn(Unix un) { final String METHOD_NAME
	 * = "saveUserDetails"; logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME,
	 * "ENTRY");
	 * 
	 * List<Unix> ulist=null; try { Session session = this.getCurrentSession();
	 * Query query1 = session.createQuery("select un from Unix un"); ulist =
	 * query1.getResultList();
	 * 
	 * }catch (Exception e) { e.printStackTrace();
	 * 
	 * } return ulist; }
	 * 
	 * @Override public Unix searchUnixQustn(Unix demo1) { final String METHOD_NAME
	 * = "saveUserDetails"; logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME,
	 * "ENTRY");
	 * 
	 * List<Unix> ulist=null; try { Session session = this.getCurrentSession();
	 * demo1=session.get(Unix.class,demo1.getUqustnId()); }catch (Exception e) {
	 * e.printStackTrace();
	 * 
	 * } return demo1; }
	 * 
	 * @Override public Linux searchLinuxQustn(Linux demo1) { final String
	 * METHOD_NAME = "saveUserDetails"; logMgr.writeToLog("INFO", CLASS_NAME,
	 * METHOD_NAME, "ENTRY");
	 * 
	 * List<Unix> ulist=null; try { Session session = this.getCurrentSession();
	 * demo1 = session.get(Linux.class, demo1.getLqustnId()); }catch (Exception e) {
	 * e.printStackTrace();
	 * 
	 * } return demo1; }
	 */
	/*@Override
	public Integer addFile(FileUpload fup) {
		Integer result = 0;
		try {
			Session session = this.getCurrentSession();
			//merge is used to update existing values however this method create a copy from the passed entity object and return it. 
			FileUpload fu = (FileUpload) session.merge(fup);
			if(fup==fu){
				System.out.println("object references are equal");
			}
			if(fup.equals(fu)){
				System.out.println("content is same");
			}
			result = (Integer) session.save(fup);
		} catch (Exception e) {
			System.out.println("Exception handled" + e);
		}
		return result;
	}
*/	
	@Override
	public Integer addFile(FileUpload fup) {
		Integer result = 0;
		try {
			Session session = this.getCurrentSession();
			Criteria crt = session.createCriteria(FileUpload.class);
			//crt.add(Restrictions.ilike("userId", "va%"));
			
			//List li = crt.list();
			//criterion is the 'where' clause of SQL by using 'Restrictions.class' we can pass retriction
			Criterion c1=  Restrictions.gt("userId", "dady");
			crt.add(Restrictions.like("userId", "va%"));
			crt.add(c1);
			
			
			//Criterion c = Restrictions.gt("userId", "FHG");
			//crt.add(Restrictions.eq("userId", "12345"));
			
			List l = crt.list();
			System.out.println("list is"+l);
		//result = (Integer) session.save(fup);
		} catch (Exception e) {
			System.out.println("Exception handled" + e);
		}
		return result;
	}
	@Override
	public void getByjdbc(Editor ed) {
		String query="select * from JAVAQUSTNS ";
	
		
	}

}