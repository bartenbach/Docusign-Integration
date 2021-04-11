package edu.unomaha.docusign.project.rest;

import edu.unomaha.docusign.project.ejb.ProjectServiceImpl;
import edu.unomaha.docusign.project.entities.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProjectEndpointTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    ProjectServiceImpl documentServiceImpl;

    @InjectMocks
    ProjectEndpoint projectEndpoint;

    private static final String PROJECT_NAME = "Alphonse Elric";
    private static final long PROJECT_ID = 100L;
    private static final long USER_ID = 200L;
    private static final Date CREATION_DATE = Date.from(Instant.ofEpochMilli(2000));
    private static final Date LAST_MODIFIED_DATE = Date.from(Instant.ofEpochMilli(1000));


    @Test
    public void testGetDocumentsByBuilder(@Mock Project project) {
        Mockito.when(project.getUserId()).thenReturn(USER_ID);
        List<Project> projectList = new ArrayList<>();
        projectList.add(project);

        Mockito.when(documentServiceImpl.getProjectsByUser(USER_ID)).thenReturn(projectList);

        List<Project> documents = projectEndpoint.byBuilder(USER_ID);

        Assertions.assertNotNull(documents);
        Assertions.assertEquals(documents.size(), 1);
        Assertions.assertEquals(projectList.get(0).getUserId(), USER_ID);
    }
}
