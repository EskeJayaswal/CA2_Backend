package dtoFacades;

import dtos.ProfileDTO;
import entities.Profile;
import entities.User;
import errorhandling.EntityNotFoundException;
import facades.IFacade;
import facades.ProfileFacade;
import facades.UserFacade;
import utils.EMF_Creator;

import java.util.List;

public class ProfileDTOFacade implements IFacade<ProfileDTO> {
    private static IFacade<ProfileDTO> instance;
    private static IFacade<Profile> profileFacade;
    private static UserFacade userFacade;

    public ProfileDTOFacade() {
    }

    public static IFacade<ProfileDTO> getFacade() {
        if (instance == null) {
            profileFacade = ProfileFacade.getFacade(EMF_Creator.createEntityManagerFactory());
            userFacade = UserFacade.getUserFacade(EMF_Creator.createEntityManagerFactory());
            instance = new ProfileDTOFacade();
        }
        return instance;
    }


    @Override
    public ProfileDTO create(ProfileDTO profileDTO) {
        Profile p = profileDTO.getEntity();
        p = profileFacade.create(p);
        return new ProfileDTO(p);
    }

    @Override
    public ProfileDTO getById(int id) throws EntityNotFoundException {
        return new ProfileDTO(profileFacade.getById(id));
    }

    @Override
    public List<ProfileDTO> getAll() {
        return ProfileDTO.toList(profileFacade.getAll());
    }

    @Override
    public ProfileDTO update(ProfileDTO profileDTO) throws EntityNotFoundException {
        Profile profile = new Profile(profileDTO.getFirstName(), profileDTO.getLastName(), profileDTO.getEmail());
        profile.setId(profileDTO.getId());
        Profile p = profileFacade.update(profile);
        return new ProfileDTO(p);
    }

    @Override
    public ProfileDTO delete(int id) throws EntityNotFoundException {
        return new ProfileDTO(profileFacade.delete(id));
    }
}
