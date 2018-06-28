package epam.converter;

import epam.form.NewsForm;
import epam.model.dto.NewsDTO;
import epam.model.entity.News;

public interface NewsConverter {

    NewsDTO formToDTO(NewsForm newsForm);

    News DTOToEntity(NewsDTO newsDTO);

    NewsDTO entityToDTO(News news);

    void DTOToForm(NewsDTO newsDTO, NewsForm newsForm);
}
