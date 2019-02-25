package org.example.application.domain.search.pagenation.impl;


import org.example.application.domain.search.pagenation.IRangeCriteria;
import org.example.application.infrastructure.util.check.Verifications;

/**
 * Pagination parameters for data retrieval operations
 *
 * @author Kul'baka Alex.
 */
// TODO: 04.02.2019 maybe interface
public class RangeCriteriaImpl implements IRangeCriteria {

    /**
     * Page index (0 - based)
     */
    private final int pageCount;

    /**
     * count of element by each page
     */
    private final int rowCountOnPage;

    public RangeCriteriaImpl(int pageCount, final int rowCountOnPage) {
        Verifications.verifyArg(pageCount >= 0, "incorrect page count");
        Verifications.verifyArg(rowCountOnPage >= 0, "incorrect row count");
        this.pageCount = pageCount;
        this.rowCountOnPage = rowCountOnPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getRowCountOnPage() {
        return rowCountOnPage;
    }

    @Override
    public String toString() {
        return "RangeCriteriaImpl{" +
                "pageCount=" + pageCount +
                ", rowCountOnPage=" + rowCountOnPage +
                '}';
    }
}
