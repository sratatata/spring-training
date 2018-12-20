package pl.training.bank.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageViewModel<T> {

    private List<T> data;
    private int pageNumber;
    private int totalPages;

}
