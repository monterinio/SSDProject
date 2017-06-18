package pl.pwr.miki.DAO;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import pl.pwr.miki.model.ReportDetailModel;
import pl.pwr.miki.model.ReportModel;

public class ReportDetailDAO {

	public boolean addReportToDB(HttpServletRequest request, long checksum) throws IOException, ServletException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		ReportDetailModel reportDetailModel = entityManager.find(ReportDetailModel.class, checksum);
		entityManager.getTransaction().commit();
		if (reportDetailModel != null) {
			return false;
		}

		reportDetailModel = new ReportDetailModel();
		ReportModel reportModel = new ReportModel();
		
		extractDataFromRequest(request, reportModel, reportDetailModel);
		reportDetailModel.setHashValue(checksum);

		entityManager.getTransaction().begin();
		entityManager.persist(reportModel);
		entityManager.persist(reportDetailModel);
		entityManager.getTransaction().commit();
		
		entityManager.close();
        entityManagerFactory.close();

		return true;
	}
	
	public List<ReportModel> getReportsFromDB() {
		
		List<ReportModel> reportModelList;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		TypedQuery<ReportModel> query = entityManager.createQuery("SELECT r FROM ReportModel r", ReportModel.class);
		reportModelList = query.getResultList();
		entityManager.getTransaction().commit();
		
		entityManager.close();
        entityManagerFactory.close();
        
		return reportModelList;
	}

	private void extractDataFromRequest(HttpServletRequest request, ReportModel reportModel,
			ReportDetailModel reportDetailModel) throws IOException, ServletException {
		reportDetailModel.setFileName(Paths.get(request.getPart("report").getSubmittedFileName()).getFileName().toString());
		reportDetailModel.setFile(IOUtils.toByteArray(request.getPart("report").getInputStream()));
		reportModel.setFileName(Paths.get(request.getPart("report").getSubmittedFileName()).getFileName().toString());
		reportModel.setFirstName(request.getParameter("firstName"));
		reportModel.setLastName(request.getParameter("lastName"));
		reportModel.setSubject(request.getParameter("subject"));
		reportModel.setTopic(request.getParameter("topic"));
	}
}
