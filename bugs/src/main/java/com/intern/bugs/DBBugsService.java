package com.intern.bugs;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

final class DBBugsService implements BugsService {
    private BugsRepository repository;

    @Autowired
    DBBugsService(BugsRepository repository) {
        this.repository = repository;
    }

    @Override
    public BugsDTO create(BugsDTO bug) {
        BugsEntity persist=null;
        try {
            persist = BugsEntity.getBuilder()
                                        .title(bug.getTitle())
                                        .desc(bug.getDesc())
                                        .status(bug.getStatus())
                                        .devAssign(bug.getDevAssigned())
                                        .tesAssign(bug.getTesAssigned())
                                        .build();
            persist = repository.save(persist);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return convertToDTO(persist);
    }

    @Override
    public BugsDTO delete(String id) {
        BugsEntity deleted = findBugById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<BugsDTO> findAll() {
        List<BugsEntity> allBugs = repository.findAll();
        return convertToDTOs(allBugs);
    }

    @Override
    public BugsDTO findById(String id) {
        BugsEntity bug = findBugById(id);
        return convertToDTO(bug);
    }

    @Override
    public BugsDTO update(BugsDTO bug) {
        BugsEntity buge = findBugById(bug.getId());
        buge.update(bug.getTitle(), 
                    bug.getDesc(), 
                    bug.getStatus(),
                    bug.getDevAssigned(), 
                    bug.getTesAssigned());
        buge = repository.save(buge);
        return convertToDTO(buge);
    }

    private BugsEntity findBugById(String id) {
        Optional<BugsEntity> bug = repository.findById(id);
        return bug.orElseThrow(() -> new BugNotFoundException(id));
    }

    private BugsDTO convertToDTO (BugsEntity bug) {
        BugsDTO dto = new BugsDTO();
        dto.setId(bug.getId());
        dto.setTitle(bug.getTitle());
        dto.setDesc(bug.getDesc());
        dto.setStatus(bug.getStatus());
        dto.setDevAssigned(bug.getDevAssigned());
        dto.setTesAssigned(bug.getTesAssigned());
        dto.setFiledAt(bug.getFiledAt());
        return dto;
    }

    private List<BugsDTO> convertToDTOs (List<BugsEntity> bugs) {
        List<BugsDTO> allBugs = bugs.stream()
                                    .map(this::convertToDTO)
                                    .collect(Collectors.toList());
        return allBugs;
    }
}