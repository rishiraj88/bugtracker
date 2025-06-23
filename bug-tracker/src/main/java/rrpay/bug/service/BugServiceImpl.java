package rrpay.bug.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rrpay.bug.dto.BugDto;
import rrpay.bug.exception.BugsNotFoundException;
import rrpay.bug.model.Bug;
import rrpay.bug.repo.BugRepository;

import java.util.List;

import static rrpay.bug.util.EntityDtoMapper.dtoToEntity;
import static rrpay.bug.util.EntityDtoMapper.entityToDto;

@Service
@RequiredArgsConstructor
public class BugServiceImpl implements BugService {
    // @RequiredArgsConstructor annotation takes care of autowiring by constructor
    // Hence no need for @Autowired annotation on the field declaration
    private final BugRepository bugRepository;

    @Override
    public List<BugDto> getBugs() {
        List<Bug> bugs = bugRepository.findAll();
        if (bugs.isEmpty()) {
            throw new BugsNotFoundException();
        }
        return bugs.stream().map(bug -> entityToDto(bug)).toList(); // Stream.toList() available in Java SE 17
    }

    @Override
    public BugDto createBug(BugDto bugDto) {
        return entityToDto(bugRepository.save(dtoToEntity(bugDto)));
    }

    @Override
    public List<BugDto> getBugsByCode(String code) {
        List<Bug> bugs = bugRepository.findByCode(code);
        if (bugs.isEmpty()) {
            throw new BugsNotFoundException(code);
        }
        return bugs.stream().map(bug -> entityToDto(bug)).toList();
    }

    @Override
    public BugDto getOneBugByCode(String code) {
        List<Bug> bugList = bugRepository.findByCode(code);
        if (bugList.isEmpty()) {
            throw new BugsNotFoundException(code);
        }
        return entityToDto(bugList.get(0));
    }

    @Override
    public void deleteBug(String code) {
        List<Bug> bugList = bugRepository.findByCode(code);
        if (bugList.isEmpty()) {
            throw new BugsNotFoundException(code);
        }
        bugRepository.deleteByCode(code);
    }

    @Override
    public void deleteAllBugs() {
        bugRepository.deleteAll();
    }

    @Override
    public void updateBugDescription(String code, String description) {
        List<Bug> bugList = bugRepository.findByCode(code);
        if (bugList.isEmpty()) {
            throw new BugsNotFoundException(code);
        }
        bugList.stream().forEach(b -> b.setDescription(description));
        bugRepository.saveAll(bugList);
    }
}
