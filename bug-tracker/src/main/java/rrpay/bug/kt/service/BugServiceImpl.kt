package rrpay.bug.kt.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BugServiceImpl:BugService {
    // @RequiredArgsConstructor annotation takes care of autowiring by constructor
    // Hence no need for @Autowired annotation on the field declaration
    @Autowired lateinit var BugRepository bugRepository;

    @Override
     getBugs():List<BugDTO>  {
        bugs :List<Bug> = bugRepository.findAll();
        return bugs.stream().map(bug-> entityToDto(bug)).toList(); // Stream.toList() available in Java SE 17
    }

    @Override
      createBug(bugDTO:BugDTO ):Bug {
        return bugRepository.save(dtoToEntity(bugDTO));
    }

    @Override
     getBugsByCode( code:String):List<BugDTO>  {
        return bugRepository.findByCode(code).stream().map(bug ->entityToDto(bug)).toList();
    }
    @Override
     getOneBugByCode(code:String ) :BugDTO {
         bugList:List<Bug> = bugRepository.findByCode(code);
        if(null == bugList || bugList.isEmpty()){
            return null;
        }
        return entityToDto(bugList.get(0));
    }

    @Override
      deleteBug(code:String ):Unit {
        bugRepository.deleteByCode(code);
    }

    @Override
      deleteAllBugs() :Unit{
        bugRepository.deleteAll();
    }

    @Override
    public  updateBugDescription(code:String, description:String) :String{
         bugList :List<Bug>= bugRepository.findByCode(code);
        if(null == bugList || bugList.isEmpty()){
            return "Update not done for reason: No matching bug found.";
        }
         bug:Bug = bugList.get(0);
        bug.setDescription(description);
        bugRepository.save(bug);
        return "The description of the matching bug has been updated.";
    }

}