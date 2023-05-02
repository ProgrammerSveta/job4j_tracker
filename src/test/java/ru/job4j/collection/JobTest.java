package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityReverse() {
        Comparator<Job> cmpNamePriority = new JobSortByName().thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
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

    @Test
    public void whenJobSortByPriorityIsOK() {
        List<Job> jobs = Arrays.asList(
                new Job("X task", 1),
                new Job("X task", 0),
                new Job("Fix bug", 2)
        );

        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("X task", 1),
                new Job("Fix bug", 2)
        );
        jobs.sort(new JobSortByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobDescByNameIsOK() {
        List<Job> jobs = Arrays.asList(
                new Job("Copy data", 1),
                new Job("X task", 0),
                new Job("Fix bug", 2)
        );

        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug", 2),
                new Job("Copy data", 1)
        );
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobDescByPriorityIsOK() {
        List<Job> jobs = Arrays.asList(
                new Job("X task", 1),
                new Job("X task", 0),
                new Job("Fix bug", 2)
        );

        List<Job> expected = Arrays.asList(
                new Job("Fix bug", 2),
                new Job("X task", 1),
                new Job("X task", 0)
        );
        jobs.sort(new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }
}