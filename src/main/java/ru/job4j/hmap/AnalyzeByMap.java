package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int sub = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject s : subjects) {
                score += s.score();
                sub++;
            }
        }
        return score / sub;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            double score = 0;
            int sub = 0;
            for (Subject s : subjects) {
                score += s.score();
                sub++;
            }
            score = score / sub;
            label.add(new Label(pupil.name(), score));
        }
        return label;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject s : subjects) {
                int score = 0;
                if (temp.get(s.name()) != null) {
                    score = temp.get(s.name());
                }
                temp.put(s.name(), s.score() + score);
            }
        }
        for (String key : temp.keySet()) {
            Label subject = new Label(key, temp.get(key) / pupils.size());
            label.add(subject);
        }
        return label;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            double score = 0;
            for (Subject s : subjects) {
                score += s.score();
            }
            label.add(new Label(pupil.name(), score));
        }
        label.sort(Comparator.naturalOrder());
        return label.get(label.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject s : subjects) {
                int score = 0;
                if (temp.get(s.name()) != null) {
                    score = temp.get(s.name());
                }
                temp.put(s.name(), s.score() + score);
            }
        }
        for (String key : temp.keySet()) {
            Label subject = new Label(key, temp.get(key));
            label.add(subject);
        }
        label.sort(Comparator.naturalOrder());
        return label.get(label.size() - 1);
    }
}