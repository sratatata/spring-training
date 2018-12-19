package pl.training.bank.common.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "page")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageTo<T> {

    private List<T> data;
    private int pageNumber;
    private int totalPages;

}
