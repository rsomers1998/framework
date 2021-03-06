/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package dev.galasa.framework.spi;

import java.time.Instant;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author Michael Baylis
 *
 */
public interface IResultArchiveStoreDirectoryService {

    @NotNull
    String getName();

    boolean isLocal();

    @NotNull
    List<IRunResult> getRuns(@NotNull String runName) throws ResultArchiveStoreException;

    /**
     * Get runs within the parameters specified
     * 
     * @param requestor who requested the run
     * @param from      UTC inclusive
     * @param to        UTC excluise
     * @return Run result
     * @throws ResultArchiveStoreException if there are errors accessing the RAS
     */
    @NotNull
    List<IRunResult> getRuns(String requestor, Instant from, Instant to) throws ResultArchiveStoreException;

    @NotNull
    List<String> getRequestors() throws ResultArchiveStoreException;

    @NotNull
    List<String> getTests() throws ResultArchiveStoreException;
}
