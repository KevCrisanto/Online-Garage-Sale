package maverick.ogs.dao;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.Files;
import maverick.ogs.util.HibernateUtil;

public class FileDAOImpl implements FileDAO {

	@Override
	public String insertFile(Files file) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		String id = null;
		
		try {
			transaction = session.beginTransaction();
			id = (String)session.save(file);
			transaction.commit();
		}
		catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		return id;
	}

	@Override
	public Files getFileById(String Id) {
		Files file = null;
		Session session = HibernateUtil.getSession();
		
		try {
			file = (Files)session.get(Files.class, Id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return file;
	}

	@Override
	public Boolean updateFileById(String fileId, Files newFile) {
		Files fileToUpdate = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			fileToUpdate = (Files)session.get(Files.class, fileId);
			if(fileToUpdate != null) {
				fileToUpdate.setFilekey(newFile.getFilekey());
			}
			session.save(fileToUpdate);
			transaction.commit();
			result = true;
		}
		catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Boolean deleteFileById(String fileId) {
		Files file = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			file = (Files)session.get(Files.class, fileId);
			if(file != null) {
				session.delete(file);
				transaction.commit();
				result = true;
			}			
		}catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		return result;
	}

}
