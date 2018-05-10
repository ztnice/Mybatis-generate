package sql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

@Service("baseSQLUtil")
public class BaseSQLUtil implements IBaseSQLUtil {
	@SuppressWarnings({ "unchecked" })
	public <T> T executeQueryById(T suppliers, String by) {
		SqlSession session = null;
		T result = null;
		try {
			SqlSessionFactory f = FactoryManager.getInstance();
			session = f.openSession();
			System.out.println("执行的sql语句为:" + by);
			if (suppliers == null) {
				result = (T) session.selectOne(by);
			} else {
				// session.insert(by, suppliers);
				result = (T) session.selectOne(by, suppliers);
			}
			// session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// session.rollback(true);
		} finally {
			// if (session != null)
			// session.close();
		}
		return result;
	}

	public <T> int executeInsert(T suppliers, String by) {
		SqlSession session = null;
		int result = 0;
		try {
			SqlSessionFactory f = FactoryManager.getInstance();
			session = f.openSession();
			System.out.println("执行的sql语句为:" + by);
			if (suppliers == null) {
				result = session.insert(by);
			} else {
				// session.insert(by, suppliers);
				result = session.insert(by, suppliers);
			}
			session.commit();
		} catch (Exception e) {
			session.rollback(true);
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	public <T> List<T> executeQuery(T suppliers, String by) {
		SqlSession session = null;
		List<T> result = null;
		try {
			SqlSessionFactory f = FactoryManager.getInstance();
			session = f.openSession();
			System.out.println("执行的sql语句为:" + by);
			if (suppliers == null) {
				result = session.selectList(by);
			} else {
				result = session.selectList(by, suppliers);
			}
			// session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// session.rollback(true);
		} finally {
			// if (session != null)
			// session.close();
		}
		return result;
	}

	public <T, E> List<T> executeQueryByPass(T suppliers, E pass, String by) {
		SqlSession session = null;
		List<T> result = null;
		try {
			SqlSessionFactory f = FactoryManager.getInstance();
			session = f.openSession();
			System.out.println("执行的sql语句为:" + by);
			if (suppliers == null) {
				result = session.selectList(by);
			} else {
				result = session.selectList(by, pass);
			}
			// session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
			// session.rollback(true);
		} finally {
			// if (session != null)
			// session.close();
		}
		return result;
	}

	public <T> int executeUpdate(T suppliers, String by) {
		SqlSession session = null;
		int result = 0;
		try {
			SqlSessionFactory f = FactoryManager.getInstance();
			session = f.openSession();
			System.out.println("执行的sql语句为:" + by);
			if (suppliers == null) {
				result = session.update(by);
			} else {
				result = session.update(by, suppliers);
			}
			session.commit(true);
		} catch (Exception e) {
			session.rollback(true);
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	public <T> int executeDelete(T suppliers, String by) {
		SqlSession session = null;
		int result = 0;
		try {
			SqlSessionFactory f = FactoryManager.getInstance();
			session = f.openSession();
			System.out.println("执行的sql语句为:" + by);
			if (suppliers == null) {
				result = session.delete(by);
			} else {
				result = session.delete(by, suppliers);
			}
			session.commit(true);
		} catch (Exception e) {
			session.rollback(true);
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}
}
