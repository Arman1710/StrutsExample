package epam.converter;

import epam.form.CommentForm;
import epam.model.entity.Comment;
import epam.model.dto.CommentDTO;

public interface CommentConverter {

    CommentDTO formToDTO(CommentForm commentForm);

    Comment DTOToEntity(CommentDTO commentDTO);

    CommentDTO entityToDTO(Comment comment);

    CommentForm DTOToForm(CommentDTO commentDTO);
}
