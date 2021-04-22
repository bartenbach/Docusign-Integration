package edu.unomaha.docusign.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import edu.unomaha.docusign.project.entities.Project;

@ExtendWith(MockitoExtension.class)
public class ProjectDaoTest {

    @Mock
    private EntityManager em;

    @Mock
    private Project project;

    @InjectMocks
    private ProjectDao projectDao;

    private static final long USER_ID = 100L;

    @Test
    public void testFindAllDocumentsByBuilder(@Mock TypedQuery<Project> typedQuery, @Mock Project project) {
        typedQuery.setParameter(Mockito.anyString(), Mockito.anyLong());
        Mockito.when(em.createNamedQuery(Project.getFindAllByUser(), Project.class)).thenReturn(typedQuery);
        Mockito.when(typedQuery.setParameter(Mockito.anyString(), Mockito.anyLong())).thenReturn(typedQuery);
        List<Project> documentList = new ArrayList<>();
        Mockito.when(project.getUserId()).thenReturn(USER_ID);
        documentList.add(project);
        Mockito.when(typedQuery.getResultList()).thenReturn(documentList);

        List<Project> resultList = projectDao.findAllProjectsByUser(USER_ID);
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(resultList.size(), 1);
        Assertions.assertEquals(resultList.get(0).getUserId(), USER_ID);
    }
}
