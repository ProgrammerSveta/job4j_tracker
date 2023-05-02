package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityReverse() {
        Comparator<Job> cmpNamePriority = new JobSortByName().thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobSortByNameIsOK() {
        List<Job> jobs = Arrays.asList(
                new Job("Copy data", 1),
                new Job("X task", 0),
                new Job("Fix bug", 2)
        );

        List<Job> expected = Arrays.asList(
                new Job("Copy data", 1),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        jobs.sort(new JobSortByName());
        assertThat(jobs).isEqualTo(expected);
    }
}