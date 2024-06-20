package rrpay.bug.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rrpay.bug.dto.BugDTO;
import rrpay.bug.model.Bug;
import rrpay.bug.repo.BugRepository;
import static rrpay.bug.util.EntitoDtoMapper.*;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BugServiceImpl implements BugService {
    private final BugRepository bugRepository;

    @Override
    public List<BugDTO> getBugs() {
        List<Bug> bugs = bugRepository.findAll();
        return bugs.stream().map(bug-> entityToDto(bug)).toList(); // Stream.toList() available in Java SE 17
    }

    @Override
    public Bug createBug(BugDTO bugDTO) {
        return bugRepository.save(dtoToEntity(bugDTO));
    }

    @Override
    public List<BugDTO> getBugsByCode(String code) {
        return bugRepository.findByCode(code).stream().map(bug ->entityToDto(bug)).toList();
    }
    @Override
    public BugDTO getOneBugByCode(String code) {
        return entityToDto(bugRepository.findByCode(code).get(0));
    }
    @Override
    public void deleteBug(String code) {
        bugRepository.deleteByCode(code);
    }

    @Override
    public void deleteAllBugs() {
        bugRepository.deleteAll();
    }

    @Override
    public void updateBugDescription(String code, String description) {
        Bug bug = bugRepository.findByCode(code).get(0);
        bug.setDescription(description);
        bugRepository.save(bug);
    }
}
